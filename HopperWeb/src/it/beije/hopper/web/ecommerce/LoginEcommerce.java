package it.beije.hopper.web.ecommerce;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginEcommerce
 */
@WebServlet("/loginEcommerce")
public class LoginEcommerce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginEcommerce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ciaooooo ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		String page = "ecommerce/home.jsp";
		
		if (username != null && username.length() > 0 && password != null && password.length() > 0) {
			//verifico credenziali su DB...
			
			User user = UserConnections.login(username, password);
			
			if (user != null) { //OK
				StringBuilder string = new StringBuilder("ecommerce/home.jsp?fname=")
						.append(user.getName())
						.append("&lname=")
						.append(user.getSurname());
				
				//response.sendRedirect(string.toString());
				session.setAttribute("fname", user.getName());
				session.setAttribute("lname", user.getSurname());
				session.setAttribute("loggedUser", user);
				page = "ecommerce/home.jsp";
			} else { //KO
				//response.sendRedirect("login.jsp?error=1");
				session.setAttribute("errore", "CREDENZIALI ERRATE");
				page = "ecommerce/login_user.jsp";
			}
		} else {
			//response.sendRedirect("login.jsp?error=2");
			session.setAttribute("errore", "INSERIRE ENTRAMBE LE CREDENZIALI");
			page = "ecommerce/login_user.jsp";
		}

		response.sendRedirect(page);
	}
	

}
