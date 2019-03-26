package servlet;

import dao.UserDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metier.User;
import dao.DaoFactory;
import dao.sourceData;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

    static DaoFactory maFactory;
    static UserDao userManager; 

    public void init() throws ServletException {
    	maFactory = DaoFactory.getDaoFactory(sourceData.JDBC);
    	Login.userManager = maFactory.getUserDao();
    }    
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

    	this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	
	}
	
	    /**
	     *
	     * @param request
	     * @param response
	     * @throws ServletException
	     * @throws IOException
	     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try{	    
	
	     User user = new User();
	     user.setPseudo(request.getParameter("un"));
	     user.setPassword(request.getParameter("pw"));
	     user = userManager.login(user);
	     System.out.println(user);                           
	     if (user.isValid())
	     {
		        
	          HttpSession session = request.getSession(true);	    
	          session.setAttribute("currentSessionUser",user); 
	          response.sendRedirect("/home"); //logged-in page      		
	     }
		        
	     else 
	          response.sendRedirect("/login"); //error page
		} 
		catch (Throwable theException){
		     System.out.println(theException); 
		}
	}
}

