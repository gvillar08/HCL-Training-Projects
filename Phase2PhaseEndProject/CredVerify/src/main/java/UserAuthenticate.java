import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import com.example.HibernateUtil;
import com.example.User;

/**
 * Servlet implementation class UserAuthenticate
 */
@WebServlet
public class UserAuthenticate extends HttpServlet {		//this servlet is for user logins
    private static final long serialVersionUID = 1L;
         
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAuthenticate() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
	    	Session session = HibernateUtil.getSessionFactory().openSession();								//boots up hibernate
            // using HQL
            List<User> list = session.createQuery("from User", User.class).list();
            session.close();
                        
	        String username = request.getParameter("username");												//store user inputs to variables
	        String password = request.getParameter("password");
            boolean usernameFound = false;
            
            if(list.size() == 0)																			//if there are no users in the database...
        	{
                request.setAttribute("errorMessage", "There are no users! Try <a href='newAcct.jsp'>creating an account</a><br>");
                request.getRequestDispatcher("main.jsp").forward(request, response);						//...notify the user through an error and give a convenient hyperlink for creating an account
        	}
            else
            {
	            for(User u : list) {																		//for every user in the database...
	                if(username.equals(u.getName()))														//...check if the username entry is a match
	                {
	                	if(password.equals(u.getPassword()))												//if there is a match, check if the password is also a match...
	                		request.getRequestDispatcher("landing.jsp").forward(request, response);			//...and forward the user to landing.jsp if it is a match
		            	else
		            	{
		                    request.setAttribute("errorMessage", "Invalid password<br>");
		                    request.getRequestDispatcher("main.jsp").forward(request, response);			//if the password doesn't match, notify the user through an error
		            	}
	                	usernameFound = true;																//set to true to avoid sending another dispatcher later...
	                	break;																				//...and break as there will be no more username matches since each username is unique
	            	}
	            }
	            
	            if(usernameFound == false)																	//if the username wasn't found...
	            {
	                request.setAttribute("errorMessage", "Invalid username<br>");
	                request.getRequestDispatcher("main.jsp").forward(request, response);					//...notify the user through an error
	            }
            }
        }
        catch (Exception eggs) {
            throw eggs;
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
    }
}