package it.beije.hopper.web;

//import it.beije.hopper.ecommerceMod.EcommerceJPA;
//import it.beije.hopper.ecommerceMod.models.Product;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;


import it.beije.hopper.ecommerceMod.EcommerceJPA;
import it.beije.hopper.ecommerceMod.models.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@WebServlet(name = "UtilServlet", value = "/UtilServlet")
public class UtilServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("HopperWeb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        // --- Get all Data
        //list of all available products in the shop
        List<Product> products = EcommerceJPA.getAllProducts(entityManager);
        System.out.println( "inside doGet(): " + products );
        // -- set attributes
        request.setAttribute("product_list", products);


        // -- get request dispatcher (used to send data from servlet to JSP)
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("shopPage.jsp");

        //-- forward data to JSP
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
