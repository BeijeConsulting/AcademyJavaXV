package it.beije.hopper.web;


import it.beije.hopper.ecommerceMod.EcommerceJPA;
import it.beije.hopper.ecommerceMod.models.User;

import java.io.IOException;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServletMod")
public class LoginServletMod extends HttpServlet {
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
        System.out.println("username : " + email);
        System.out.println("password : " + password);

        HttpSession session = request.getSession();
        String page = "loginMod.jsp";

        if (email != null && email.length() > 0 && password != null && password.length() > 0) {
            //verifico credenziali su DB...
            if (EcommerceJPA.login(email, password)) { //OK
//				response.sendRedirect("welcome.jsp?fname=Pippo&lname=Rossi");

                User u = new User();
                u=EcommerceJPA.getUser(email);
                session.setAttribute("fname", u.getName());
                session.setAttribute("lname", u.getSurname());
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
