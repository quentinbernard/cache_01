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
import dao.UserDao;
import dao.sourceData;
import metier.Cachette;
import metier.User;

/**
 * Servlet implementation class GestionUsers
 */
@WebServlet("/GestionUsers")
public class GestionUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static DaoFactory maFactory;
    static UserDao userManager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public GestionUsers() {
        super();
        // TODO Auto-generated constructor stub
    }*/
    public void init() throws ServletException {
    	maFactory = DaoFactory.getDaoFactory(sourceData.JDBC);
    	GestionUsers.userManager = maFactory.getUserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		
		if(user != null && user.isValid()) {
			request.setAttribute("users",  userManager.findAll());
			this.getServletContext().getRequestDispatcher("/WEB-INF/Users.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("/login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u;
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		
		if(user != null && user.isValid()) {
			switch (request.getParameter("btn_user"))
			{
				case "MODIFIER":
					u = userManager.find(Integer.parseInt(request.getParameter("idt_user")));
					u.setValid(request.getParameter("etat_user"));
					u.setType(request.getParameter("type_user"));
					userManager.update(u);
					break;
				default:
					break;
			}
			request.setAttribute("users",  userManager.findAll());
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Users.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("/login");
		}
	}

}
