package servlets;

import java.io.IOException;
import java.util.ArrayList;

import DAO.GuestboardDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Guestboard;


@WebServlet("/guestboard/list")
public class GuestboardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			ServletContext sc = this.getServletContext();
			
			GuestboardDao guestboardDao = (GuestboardDao)sc.getAttribute("guestboardDao");
			ArrayList<Guestboard> guestboards = guestboardDao.selectAll();
			
			request.setAttribute("guestboards", guestboards);
			RequestDispatcher rd = request.getRequestDispatcher("/guestboard/GuestboardList.jsp");
			rd.include(request, response);
			
			
		}catch(Exception e){
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}