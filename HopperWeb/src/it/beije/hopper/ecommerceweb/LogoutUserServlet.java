package it.beije.hopper.ecommerceweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutUserServlet")
public class LogoutUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("Session before invalidate: "+ request.getSession(false));
		if(session!=null) {
			session.invalidate();
			System.out.println("Session after invalidate: "+ request.getSession(false)); 
			response.sendRedirect("loguser.jsp");
		}
	}

	

}
