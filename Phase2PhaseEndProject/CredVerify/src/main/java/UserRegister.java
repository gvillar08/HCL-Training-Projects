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
 * Servlet implementation class UserRegister
 */
@WebServlet
public class UserRegister extends HttpServlet {			//this servlet is for user registration
    private static final long serialVersionUID = 1L;
         
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegister() {
	    super();
	}

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
	        String username = request.getParameter("username");														//store user inputs to variables
	        String password1 = request.getParameter("password1");
	        String password2 = request.getParameter("password2");
	        boolean usernameFound = false;
	        																										//note that these first two if statements come before booting hibernate for a faster response time
	        if(password1==""||password2==""||username=="")															//if any of the registration fields are blank...
            {
                request.setAttribute("errorMessage", "Oops! None of the fields can be blank<br>Please try again");
                request.getRequestDispatcher("newAcct.jsp").forward(request, response);								//...notify the user through an error
            }
	        else if(!password1.equals(password2))																	//if the new passwords don't match...
            {
                request.setAttribute("errorMessage", "Oops! Your passwords didn't match<br>Please try again");
                request.getRequestDispatcher("newAcct.jsp").forward(request, response);								//...notify the user through an error
            }	        	
	        else
	        {
		    	Session session = HibernateUtil.getSessionFactory().openSession();									//boots up hibernate
	        	session.beginTransaction();
		        User user = new User();
	            // using HQL
	            List<User> list = session.createQuery("from User", User.class).list();
	            	            
	            for(User u : list) {																				//for every user in the database...
	                if(username.equals(u.getName()))																//...check if the submitted username is a match
	                {
	                    request.setAttribute("errorMessage", "Oops! That username is already taken<br>Please try a different username");
	                    request.getRequestDispatcher("newAcct.jsp").forward(request, response);						//notify the user of a match through an error...
	                	usernameFound = true;																		//...and set to true to avoid sending a second dispatcher later...
	                	break;																						//...and stop looking for matches as each username is unique and there is not a second match in the database
	            	}
	            }
	            if(usernameFound == false)																			//if the submitted username doesn't already exist...
	            {
	            	user.setName(username);
	            	user.setPassword(password2);
	                session.save(user);																				//...save and commit any changes...
	    	        session.getTransaction().commit();
		            request.setAttribute("success", "Congratulations! Account successfully created<br>Return to the <a href='main.jsp'>main menu</a> to log in");
		            request.getRequestDispatcher("newAcct.jsp").forward(request, response);							//...and notify the user, along with giving a convenient hyperlink for returning to the main menu
	            }
    	        session.close();
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