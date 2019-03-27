package servlet;

import dao.UserDao;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metier.User;
import dao.DaoFactory;
import dao.sourceData;
import dao.jdbc.JdbcDaoUser;

import javax.servlet.annotation.WebServlet;

@WebServlet("/Register")
public class Register extends HttpServlet {
	
	static DaoFactory maFactory;
    static UserDao userManager; 

    public void init() throws ServletException {
    	maFactory = DaoFactory.getDaoFactory(sourceData.JDBC);
    	userManager = maFactory.getUserDao();
    }  
    
	public Register() {	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

    	this.getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String pseudo = request.getParameter("pseudo");
		String password = request.getParameter("password");
		LocalDate today = LocalDate.now();
	      
		// (1,'CURIE','Marie','mcurie@centralelille.fr','mcurie','mcmc','2018-10-12','2018-10-12','V','A',NULL,0,0)
		
		User utilisateur = new User(nom, prenom, mail, pseudo, password, today, today, "V", "J");
		Boolean utilisateurRegistered = userManager.create(utilisateur);
		
		if(utilisateurRegistered) {
			
			 HttpSession session = request.getSession(true);	    
	         session.setAttribute("currentSessionUser",utilisateur); 
	         response.sendRedirect("/home"); //logged-in page
		} else {
			request.setAttribute("errMessage", "Erreur lors du register");
	        response.sendRedirect("/register"); //logged-in page  
		}
	}
}