package it.beije.hopper.ecommerceweb;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.hopper.entity.Product;
import it.beije.hopper.entity.User;

/**
 * Servlet implementation class ProdServlet
 */
@WebServlet("/ProdServlet")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EntityManager entityManager = JPAEntityManagerFactory.openSession();

		HttpSession session=request.getSession();
		//User user=(User)session.getAttribute("loggedUser");
		if(session!=null) {
			Query query = entityManager.createQuery("SELECT p FROM Product as p");
			List<Product> products = query.getResultList();
			Product prod=new Product();
			Carrello cart=new Carrello();
			session.setAttribute("p", prod);
			session.setAttribute("cart", cart);
			session.setAttribute("prod", products);
			response.sendRedirect("listaprodotti.jsp");
		}
		else
			response.sendRedirect("loguser.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
