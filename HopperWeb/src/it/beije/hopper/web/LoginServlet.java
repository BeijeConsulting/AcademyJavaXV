package it.beije.hopper.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet doPost...");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username != null && username.length() > 0 && password != null && password.length() > 0) {
			//verifico credenziali su DB...
			if (username.equalsIgnoreCase("pippo") && password.equalsIgnoreCase("1234")) { //OK
				response.sendRedirect("welcome.jsp?fname=Pippo&lname=Rossi");
			} else { //KO
				response.sendRedirect("login.jsp?error=1");
			}
		} else {
			response.sendRedirect("login.jsp?error=2");
		}
		
	}

}
