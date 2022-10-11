package it.beije.hopper.ecommerceweb;

import java.io.IOException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.hopper.entity.User;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signup_user")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager entityManager = JPAEntityManagerFactory.openSession();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		User user=new User();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		HttpSession session=request.getSession();
		String loc="";

		if (email != null && email.length() > 0 && password != null && password.length() > 0 && nome != null && nome.length() > 0 && cognome != null && cognome.length() > 0) {
			
			user.setEmail(email);
			user.setPassword(password);
			user.setName(nome);
			user.setSurname(cognome);
		
			entityManager.persist(user);
			transaction.commit();
			entityManager.close();	
			
//			RequestDispatcher view = request.getRequestDispatcher("welcomeweb.jsp");
//			view.forward(request, response);
			session.setAttribute("email",email);
			session.setAttribute("email",password);
			session.setAttribute("email",nome);
			session.setAttribute("email",cognome);
			loc="welcomeweb.jsp";
		}
		else {
//			RequestDispatcher view = request.getRequestDispatcher("signup_failed.html");
//			view.forward(request, response);
			session.setAttribute("errorSignup", "errorSignup");
			loc="signup.jsp";
		}
		
		response.sendRedirect(loc);
	}

}
