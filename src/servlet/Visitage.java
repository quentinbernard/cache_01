package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CachetteDao;
import dao.DaoFactory;
import dao.VisiteDao;
import dao.sourceData;
import metier.Visite;
import metier.Cachette;
import metier.User;

@WebServlet("/Visitage")
public class Visitage extends HttpServlet {
	static DaoFactory maFactory;
    static VisiteDao visiteManager; 
    static CachetteDao cachetteManager;
    
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    /*public Cache() {
        super();
        // TODO Auto-generated constructor stub
    }*/
    public void init() throws ServletException {
    	maFactory = DaoFactory.getDaoFactory(sourceData.JDBC);
    	Visitage.visiteManager = maFactory.getVisiteDao();
    	Visitage.cachetteManager = maFactory.getCachetteDao();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		System.out.println(user);
		
		if(user != null && user.isValid()) {
			request.setAttribute("visites",  visiteManager.findByUser(user.getId()));
			request.setAttribute("cachettes",  cachetteManager.findAll());
			this.getServletContext().getRequestDispatcher("/WEB-INF/Visite.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("/login");
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		System.out.println(user);
		
		if(user != null && user.isValid()) {
			Visite v;
			LocalDate today = LocalDate.now();

			switch (request.getParameter("btn_cache"))
			{
				case "CREER":
					v = new Visite(today, request.getParameter("commentaire_visite"), Integer.parseInt(request.getParameter("id_user")), Integer.parseInt(request.getParameter("id_cache")), request.getParameter("resultat_visite"));
					// LocalDate date_visite, String commentaire_visite, int id_user, int id_cache,	String resultat_visite
					visiteManager.create(v);
					break;
				case "MODIFIER":
					v = visiteManager.find(Integer.parseInt(request.getParameter("idt_visite")));
					v.setDate_visite(today);
					v.setResultat_visite(request.getParameter("resultat_visite"));
					visiteManager.update(v);
					break;
				default:
					break;
			}
			request.setAttribute("visites",  visiteManager.findByUser(user.getId()));
			request.setAttribute("cachettes",  cachetteManager.findAll());
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Visite.jsp").forward(request, response);
		} else {
			response.sendRedirect("/login");
		}
	}
}
