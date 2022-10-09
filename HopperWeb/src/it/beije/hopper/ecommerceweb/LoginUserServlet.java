package it.beije.hopper.ecommerceweb;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.hopper.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login_user")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager entityManager = JPAEntityManagerFactory.openSession();
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		System.out.println("LoginServlet doPost...");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("username : " + email);
		System.out.println("password : " + password);
		HttpServlet session;;
		
		Query query = entityManager.createQuery("SELECT u FROM User u");
		List<User> user = query.getResultList();

		int i=0;
		
		if (email != null && email.length() > 0 && password != null && password.length() > 0) {
			// verifico credenziali su DB...

			for (i = 0; i < user.size();) {
				if (email.equalsIgnoreCase(user.get(i).getEmail()) && password.equalsIgnoreCase(user.get(i).getPassword())) { // OK
					RequestDispatcher view = request.getRequestDispatcher("welcome.jsp");
					
					view.forward(request, response);
					break;
				} else { //KO
//					RequestDispatcher view = request.getRequestDispatcher("loginusererror.html");
//					view.forward(request, response);
//					break;
					
				}
			}
		} else {
			// response.sendRedirect("login.jsp?error=2");
			RequestDispatcher view = request.getRequestDispatcher("loginusererror.html");
			view.forward(request, response);
		}
		
		
	}
}
