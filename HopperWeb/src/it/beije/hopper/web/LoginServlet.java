package it.beije.hopper.web;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import jakarta.persistence.*;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import it.beije.hopper.web.ecommerce.ECommerceComando;
import it.beije.hopper.web.ecommerce.Product;
import it.beije.hopper.web.ecommerce.User;

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

        List<Product> products = entityManager.createQuery("from Product p", Product.class).getResultList();
        for (Product p: products) {
            System.out.println(p);
        }

        entityManager.close();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		//ECommerceComando.login(username,password);
	
		
		HttpSession session = request.getSession();
		String page = "login.jsp";
		
		if (username != null && username.length() > 0 && password != null && password.length() > 0) {
			//verifico credenziali su DB...
			if (username.equalsIgnoreCase("pippo@beije.it") && password.equalsIgnoreCase("1234")) { //OK
//				response.sendRedirect("welcome.jsp?fname=Pippo&lname=Rossi");
//				session.setAttribute("fname", "Pippo");
//				session.setAttribute("lname", "Rossi");
				
				User user = new User();
				user.setEmail(username);
				user.setFirstName("Pippo");
				user.setLastName("Rossi");
				
				System.out.println(user);
						
				session.setAttribute("loggedUser", user);
				
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
