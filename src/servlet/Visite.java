package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CachetteDao;
import dao.DaoFactory;
import dao.VisiteDao;
import dao.sourceData;

@WebServlet("/Visite")
public class Visite extends HttpServlet {
	static DaoFactory maFactory;
    static VisiteDao visiteManager; 
    
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
    	Visite.visiteManager = maFactory.getVisiteDao();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("visites",  visiteManager.findAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/Visite.jsp").forward(request, response);
	}
}
