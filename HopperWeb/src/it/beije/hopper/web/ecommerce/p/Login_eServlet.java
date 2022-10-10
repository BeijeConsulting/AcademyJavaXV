package it.beije.hopper.web.ecommerce.p;

import java.io.IOException;
import java.util.List;

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
import it.beije.hopper.web.ecommerce.Product;
import it.beije.hopper.web.ecommerce.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/logine")
public class Login_eServlet extends HttpServlet {
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
		String page = "login_e.jsp";
		
		if (username != null && username.length() > 0 && password != null && password.length() > 0) {
			//verifico credenziali su DB...
			
			EntityManager entityManager = JPAEntityManagerFactory.openSession();

			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			
			
		Query query = entityManager.createQuery("SELECT u FROM User as u WHERE email ='"+username+"'AND password ='"+password+"'");
		 List<User> user = query.getResultList();
	
			//if (username.equalsIgnoreCase(u.getEmail()) && password.equalsIgnoreCase(u.getPassword())) { //OK
				if(query.getResultList().size() != 0){
					for (User u : user) {
				session.setAttribute("fname",u.getName());
				session.setAttribute("lname", u.getSurname());
					}
					
				
					
				page = "product.jsp";
				
				Query query1 = entityManager.createQuery("SELECT p FROM Product as p");//SELECT * FROM rubrica
				List<Product> product = query1.getResultList();
				
					session.setAttribute("prod", product);
				
			} else{  //KO
				session.setAttribute("errore", "CREDENZIALI ERRATE");
			}
			
		//}
		} else {
			session.setAttribute("errore", "INSERIRE ENTRAMBE LE CREDENZIALI");
		}
		

		response.sendRedirect(page);
	}

}
