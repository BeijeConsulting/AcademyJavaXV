package it.beije.hopper.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
     * Servlet implementation class LoginServlet
     */
    @WebServlet("/newProduct")
    public class newProduct extends HttpServlet {

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.getWriter().append("Served at: ").append(request.getContextPath());
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Product newP = new Product();
            newP.setName(request.getParameter("nome"));
            newP.setDesc(request.getParameter("descrizione"));
            newP.setPrice(Double.parseDouble(request.getParameter("prezzo")));
            newP.setQuantity(Integer.parseInt(request.getParameter("quantita")));
            newP.setRating(Integer.parseInt(request.getParameter("rating")));
            newP.setPromo(Integer.parseInt(request.getParameter("promo")));

            try {
                LoginServlet.entityTransaction.begin();
                LoginServlet.entityManager.persist(newP);
                LoginServlet.entityTransaction.commit();
                response.getWriter().append("Hai inserito correttamente il nuovo prodotto!!!");
            }catch (NumberFormatException p){
                response.getWriter().append("Hai inserito dati non corretti, riprova!!!");
                LoginServlet.entityTransaction.rollback();
            }catch (Exception e){
                response.getWriter().append("Hai inserito dati non coertwertywerywertyertyrretti, riprova!!!");
                LoginServlet.entityTransaction.rollback();
            }
        }
    }

