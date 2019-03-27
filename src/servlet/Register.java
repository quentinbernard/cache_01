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

public class Register extends HttpServlet {
	public Register() {	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JdbcDaoUser userManager = new JdbcDaoUser();

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String pseudo = request.getParameter("pseudo");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		LocalDate today = LocalDate.now();
	      
		// (1,'CURIE','Marie','mcurie@centralelille.fr','mcurie','mcmc','2018-10-12','2018-10-12','V','A',NULL,0,0)
		
		User utilisateur = new User(nom, prenom, mail, pseudo, password, today, today, "V", "A");
		Boolean utilisateurRegistered = userManager.create(utilisateur);
		
		if(utilisateurRegistered) {
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		} else {
			request.setAttribute("errMessage", "Erreur lors du register");
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
		}
	}
}