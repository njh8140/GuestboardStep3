package servlets;

import java.io.IOException;

import DAO.GuestboardDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guestboard/delete")
public class GuestboardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//삭제할 정보 받아서 DB 연결, 삭제
		//목록 화면 출력
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		try{
			ServletContext sc = this.getServletContext();
			
			GuestboardDao guestboardDao = (GuestboardDao)sc.getAttribute("guestboardDao");
			guestboardDao.delete(id);
			
			response.sendRedirect("list");
			
		}catch(Exception e){
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
		}	
}