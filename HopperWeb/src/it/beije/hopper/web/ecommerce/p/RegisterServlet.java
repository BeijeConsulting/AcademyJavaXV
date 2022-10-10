package it.beije.hopper.web.ecommerce.p;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import  javax.persistence.Query;

import it.beije.hopper.web.ecommerce.p.JPAEntityManagerFactory;
import it.beije.hopper.web.ecommerce.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
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
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
	
		
		HttpSession session = request.getSession();
		String page = "registration.jsp";
		
		EntityManager entityManager = JPAEntityManagerFactory.openSession();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		User user = new User();
		
		
		user.setSurname(cognome);
		user.setName(nome);
		user.setEmail(email);
		user.setPassword(password);
		
		entityManager.persist(user);
		entityTransaction.commit();
		entityManager.close();
		page = "login_e.jsp";
		

		response.sendRedirect(page);
	}

}