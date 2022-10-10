package it.beije.hopper.web;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HopperWeb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
//
////		List products = entityManager.createNativeQuery("SELECT * FROM Product").getResultList();
//		List products = entityManager.createQuery("from Product p").getResultList();
//		for (Object p: products) {
//			System.out.println(p.toString());
//		}
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//
////		entityTransaction.commit();
//		entityManager.close();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		
		HttpSession session = request.getSession();
		String page = "login.jsp";
		
		if (username != null && username.length() > 0 && password != null && password.length() > 0) {

			List<User> user  = entityManager.createQuery("from User u where u.email = '" + username + "' " + " and u.password = '" + password + "'").getResultList();
			if (user.size() != 0) { //OK
//				response.sendRedirect("welcome.jsp?fname=Pippo&lname=Rossi");
				session.setAttribute("fname", user.get(0).getName());
				session.setAttribute("lname", user.get(0).getSurname());
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
