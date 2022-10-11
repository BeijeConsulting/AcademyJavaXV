package it.beije.hopper.web.ecommerce.p;

import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
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
		
		
		
		String id_p = request.getParameter("id_p");
		System.out.println(id_p);
		
		HttpSession session = request.getSession();

		String page = "product.jsp";
		
		EntityManager entityManager = JPAEntityManagerFactory.openSession();
		
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		
		
		
		Product product=entityManager.find(Product.class, Integer.parseInt(id_p));
		List<Product> carrello=new ArrayList<>();
		carrello.add(product);
		System.out.println(carrello);
		
		
		session.setAttribute("carr", carrello);
		
		page = "carrello.jsp";
		
		response.sendRedirect(page);
	}

}
