package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CachetteDao;
import dao.DaoFactory;
import dao.sourceData;
import metier.Cachette;
import metier.User;

/**
 * Servlet implementation class Cache
 */
@WebServlet("/Cache")
public class Cache extends HttpServlet {
	static DaoFactory maFactory;
    static CachetteDao cachetteManager; 
    
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cache() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
    	maFactory = DaoFactory.getDaoFactory(sourceData.JDBC);
    	Cache.cachetteManager = maFactory.getCachetteDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		
		if(user != null && user.isValid()) {
			request.setAttribute("cachettes",  cachetteManager.findAll());
			request.setAttribute("cachettesUser",  cachetteManager.findByUser(user.getId()));
			this.getServletContext().getRequestDispatcher("/WEB-INF/Cache.jsp").forward(request, response);
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
		Cachette c;
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		
		if(user != null && user.isValid()) {
			switch (request.getParameter("btn_cache"))
			{
				case "CREER":
					c = new Cachette(request.getParameter("nom_cachette"),request.getParameter("coordonnees_cachette"),"C",request.getParameter("description_cachette"),user.getId());
					cachetteManager.create(c);
					break;
				case "MODIFIER":
					c = cachetteManager.find(Integer.parseInt(request.getParameter("idt_cachette")));
					c.setEtat_cache(request.getParameter("etat_cachette"));
					cachetteManager.update(c);
					break;
				default:
					break;
			}
			request.setAttribute("cachettes",  cachetteManager.findAll());
			request.setAttribute("cachettesUser",  cachetteManager.findByUser(user.getId()));
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Cache.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("/login");
		}
	}

}
