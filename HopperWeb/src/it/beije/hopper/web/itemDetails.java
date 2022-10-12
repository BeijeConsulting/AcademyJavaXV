package it.beije.hopper.web;

import it.beije.hopper.web.beans.Item;
import it.beije.hopper.web.beans.User;
import it.beije.hopper.web.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/item_details")
public class itemDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Controller controller = new Controller();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("item_details doGet...");

        String id = request.getParameter("id");
        System.out.println("id ordine : " + id);

        HttpSession session = request.getSession();
        String page = "itemDetails.jsp";

        List<Item> items = controller.viewItems(Integer.parseInt(id));
        session.setAttribute("Items", items);


        response.sendRedirect(page);
    }

}
