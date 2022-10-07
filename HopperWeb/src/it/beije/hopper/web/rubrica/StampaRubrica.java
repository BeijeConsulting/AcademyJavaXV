package it.beije.hopper.web.rubrica;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StampaRubrica
 */
@WebServlet("/stampa_rubrica")
public class StampaRubrica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StampaRubrica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			List<Contatto> contacts = GestioneConnessioniJPA.getAllContacts();
			
			StringBuilder builder = new StringBuilder();
			builder.append("<!DOCTYPE html>" + 
					"<html><head><meta charset=\"ISO-8859-1\">" + 
					"<title>Rubrica</title></head>" + 
					"<body>");
			
			for(Contatto contact : contacts) builder.append("- " + contact.toString() + "<br>");
				
			builder.append("</body>" + 
					"</html>");
		
		response.getWriter().append(builder.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
