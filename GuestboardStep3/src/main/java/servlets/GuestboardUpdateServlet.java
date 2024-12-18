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

@WebServlet("/guestboard/update")
public class GuestboardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		try{
			ServletContext sc = this.getServletContext();
			
			GuestboardDao guestboardDao = (GuestboardDao)sc.getAttribute("guestboardDao");
			
			request.setAttribute("guestboard", guestboardDao.selectOne(id));
			RequestDispatcher rd = request.getRequestDispatcher("/guestboard/GuestboardUpdate.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String inputdate = request.getParameter("inputdate");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		
		try{
			ServletContext sc = this.getServletContext();
			
			GuestboardDao guestboardDao = (GuestboardDao)sc.getAttribute("guestboardDao");
			Guestboard guestboard = new Guestboard();
			guestboard.setId(id);
			guestboard.setName(name);
			guestboard.setEmail(email);
			guestboard.setInputdate(inputdate);
			guestboard.setSubject(subject);
			guestboard.setContent(content);
			
			guestboardDao.update(guestboard);
			
			response.sendRedirect("list");
			
		}catch(Exception e){
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		}	
	}