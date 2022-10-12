package it.beije.hopper.ecommerceweb;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.hopper.entity.Order;
import it.beije.hopper.entity.User;

/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		EntityManager entityManager=JPAEntityManagerFactory.openSession();
		EntityTransaction transaction=entityManager.getTransaction();
		
		Carrello cart=(Carrello)session.getAttribute("cart");
		
		double amount=0;
		for(int i=0;i<cart.size();i++) {
			System.out.println(cart.getProduct(i));
			amount+=cart.getProduct(i).getPrice();
		}
		
		User user=(User)session.getAttribute("loggedUser");
		Order order=new Order();
		LocalDateTime localDateTime=LocalDateTime.now();
		
		order.setUserId(user.getId());
		order.setDatetime(localDateTime);
		order.setAmount(amount);
		order.setPromo(null);
		
		entityManager.persist(order);
		transaction.commit();
		session.setAttribute("done","done");
		response.sendRedirect("listaprodotti.jsp");
	}


}
