package it.beije.hopper.web;

import it.beije.hopper.ecommerceMod.EcommerceJPA;
import it.beije.hopper.ecommerceMod.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("fname");
        String surname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("username : " + email);
        System.out.println("password : " + password);

        HttpSession session = request.getSession();
        String page = "loginMod.jsp";

        if (name.length() <= 0 || surname.length() <= 0 || email.length() <= 0 || password.length() <= 0) {
            response.sendRedirect("signUp.jsp?error=1");
            session.setAttribute("error", "INSERISCI TUTTI I CAMPI!");
        } else {
            User u = new User();
            u.setName(name);
            System.out.println(name);
            u.setSurname(surname);
            System.out.println(surname);
            u.setEmail(email);
            u.setPassword(password);
            session.setAttribute("fname", u.getName());
            session.setAttribute("lname", u.getSurname());
            EcommerceJPA.addUser(u);
            response.sendRedirect("welcomeMod.jsp");
        }
    }
}
