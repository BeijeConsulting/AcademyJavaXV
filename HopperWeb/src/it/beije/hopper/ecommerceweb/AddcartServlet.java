package it.beije.hopper.ecommerceweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.hopper.entity.Product;

/**
 * Servlet implementation class AddcartServlet
 */
@WebServlet("/AddcartServlet")
public class AddcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Carrello cart=(Carrello)session.getAttribute("cart");
		Product prod=(Product)session.getAttribute("p");
		
		cart.add(prod);
		session.setAttribute("cart", cart);
		response.sendRedirect("listaprodotti.jsp");
	}

	

}
