package it.beije.hopper.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

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
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		
		HttpSession session = request.getSession();
		String page = "login.jsp";
		
		if (username != null && username.length() > 0 && password != null && password.length() > 0) {
			//verifico credenziali su DB...
			if (username.equalsIgnoreCase("pippo") && password.equalsIgnoreCase("1234")) { //OK
//				response.sendRedirect("welcome.jsp?fname=Pippo&lname=Rossi");
				session.setAttribute("fname", "Pippo");
				session.setAttribute("lname", "Rossi");
				page = "welcome.jsp";
			} else { //KO
				//response.sendRedirect("login.jsp?error=1");
				session.setAttribute("errore", "CREDENZIALI ERRATE");
			}
		} else {
			//response.sendRedirect("login.jsp?error=2");
			session.setAttribute("errore", "INSERIRE ENTRAMBE LE CREDENZIALI");
		}

		response.sendRedirect(page);
	}

}
