package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Guestboard;

import java.io.IOException;

import DAO.GuestboardDao;

@WebServlet("/guestboard/add")
public class GuestboardAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("GuestboardInsert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String inputdate = request.getParameter("inputdate");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		
		
		try{
			ServletContext sc = this.getServletContext();
			
			GuestboardDao guestboardDao = (GuestboardDao)sc.getAttribute("guestboardDao");
			
			Guestboard guestboard = new Guestboard();
			guestboard.setName(name);
			guestboard.setEmail(email);
			guestboard.setInputdate(inputdate);
			guestboard.setSubject(subject);
			guestboard.setContent(content);
			
			guestboardDao.insert(guestboard);
			response.sendRedirect("list");
		}catch(Exception e){
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		}	
}