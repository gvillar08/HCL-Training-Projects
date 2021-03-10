package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

/**
 * Servlet implementation class PetsServlet
 */
//@WebServlet("/PetsServlet")
public class PetsServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetsServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	//currently used by the "Print current registry" button only
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();							//boots up hibernate
            Session session = factory.openSession();
            List<Product> list = session.createQuery("from Product", Product.class).list();		//fetches the database info and puts it into a list
            session.close();
            PrintWriter out = response.getWriter();
                            
            out.println("<html><body>");
            out.println("<a href='webapp.jsp'>Return to menu</a><br><br>");						//hyperlink to send user back to the main menu
            out.println("<b>Animals Database</b><br>");
            out.println("<table><tr><th>Name</th><th>Color</th><th>Price</th></tr>");			//table headers for name, color, and price
            for(Product p: list) {
                out.println("<tr><td>"+p.getName()+"</td><td>"+p.getColor()+"</td><td>"+p.getPrice()+"</td></tr>");	//prints every known animal in a table format
            }
            out.println("</table></body></html>");
            
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	//currently used by the "Submit all" button only
        try
        {
	    	Session session = HibernateUtil.getSessionFactory().openSession();					//boots up hibernate
        	session.beginTransaction();
	        Product prod = new Product();
	        PrintWriter out = response.getWriter();
	        
	        String name = request.getParameter("name");
	        String color = request.getParameter("color");
	        String price = request.getParameter("price");
	        Float cost;
	        	        
	        out.println("<html><body>");
	        out.println("<a href='webapp.jsp'>Return to Main</a><br><br>");						//hyperlink to send the user back to the main menu

	        if(name==""||color==""||price=="")													//if any of the user-submitted fields are blank...
	            out.println("Please try again and ensure all fields are properly filled");		//...notify the user. Note that the user entry will never be null, and thus does not need to be checked for
	        else
	        {
	            try {
	                cost = Float.parseFloat(price);												//try parsing the user entry for price to a float
	                prod.setName(name);															//add name, color, and cost with the Product.java setters
	                prod.setColor(color);
	                prod.setPrice(BigDecimal.valueOf(cost));
	                session.save(prod);															//save and commit the changes
	    	        session.getTransaction().commit();
	    	        out.println("Animal successfully added!");									//notify the user it was successful
	            }
	            catch(Exception e)																//error is thrown if user entry cannot be converted to a float
	            {
	                out.println("Please try again and ensure the price field contains numeric values only");
	            }
	        }
	        session.close();
	        out.println("</body></html>");
        }
        catch(Exception ex)
        {
        	throw ex;
        }
    }
}