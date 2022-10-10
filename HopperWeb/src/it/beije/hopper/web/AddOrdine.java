package it.beije.hopper.web;

import it.beije.hopper.web.controller.Controller;
import it.beije.hopper.web.beans.Order;
import it.beije.hopper.web.beans.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "AddOrdine", value = "/add_ordine")
public class AddOrdine extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Controller controller = new Controller();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doPost... addOrdine...");

        HttpSession session = request.getSession();
        ArrayList<Product> prodList = (ArrayList) session.getAttribute("ProdList");
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (Product p : prodList) {
            String quantitaString = request.getParameter(p.getId().toString());
            if (quantitaString != null && !quantitaString.isEmpty() && !quantitaString.equals("0")) {
                int quantita = Integer.parseInt(quantitaString);
                hashMap.put(p.getId(), quantita);
            }
        }
        System.out.println(hashMap.toString());
        Order order = null;
        if (!hashMap.isEmpty())
            order = controller.AddOrder(1, hashMap);


        String page = "itemlist.jsp";

        if (order != null) { //OK
//			response.sendRedirect("welcome.jsp?fname=Pippo&lname=Rossi");
            session.setAttribute("ordine", order);

            page = "ordinefatto.jsp";
        } else {
            //response.sendRedirect("login.jsp?error=2");
            session.setAttribute("errore", "Ordine non effettuato");
        }

        response.sendRedirect(page);
    }
}
