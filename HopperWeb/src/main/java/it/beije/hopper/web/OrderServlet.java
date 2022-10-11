package it.beije.hopper.web;

import it.beije.hopper.ecommerceMod.models.Cart;
import it.beije.hopper.ecommerceMod.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {



    Cart cart = null;
    List<Product> products = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside OrderServlet doGet()");
        String numOfProductsInCart = request.getParameter("numOfProduct");
        String productId = request.getParameter("submit_id");



        System.out.println("value inside doGet: " + numOfProductsInCart);
        System.out.println("Id of product: " + productId);



        HttpSession session = request.getSession();

        System.out.println("ProductList: \n" + products);
        session.setAttribute("numOfProductsInCart", numOfProductsInCart);
        session.setAttribute("productId", productId);

        System.out.println();

        if( products == null ){
            System.out.println("products null initializing list of produts");
            products = (ArrayList<Product>)session.getAttribute("product_list");
        }else{
            System.out.println("Products not null");
        }
        if( cart == null ){
            cart = new Cart();
            session.setAttribute("cartSession", cart);
        }

        for( Product product: products ){
            if( product.getId().equals(Integer.valueOf(productId))){
                cart.addProduct(product, 1.0, Integer.valueOf(numOfProductsInCart));
                break;
            }

        }


        response.sendRedirect("shopPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
