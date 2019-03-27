//LogoutServlet.java
 
package servlet;
 
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

@WebServlet("/logout") 
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		 HttpSession session = request.getSession(false); //On mets l'objet � false pour qu'il ne cree pas la session!!!! 
		 if(session!=null) { //If session nest pas nulle
			 session.invalidate(); //on supprime toutes les datas concernant la session
			 request.setAttribute("errMessage", "Deconnexion réussie");
			 // RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
			 // requestDispatcher.forward(request, response);
			 response.sendRedirect("/home");
			 System.out.println("Déconnexion");
		 }
	 }
}