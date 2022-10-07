package it.beije.hopper.web.rubrica;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuRubrica
 */
@WebServlet("/menu_rubrica")
public class MenuRubrica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuRubrica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder builder = new StringBuilder();
		builder.append("<!DOCTYPE html>" + 
				"<html><head><meta charset=\"ISO-8859-1\">" + 
				"<title>Rubrica</title></head>" + 
				"<body>" + 
				"Ciao, benvenuto nella tua rubrica, inserisci l'opzione da eseguire<br>" + 
				"- <a href=\"./stampa_rubrica\">Visualizza rubrica</a>"+
				"</body>" + 
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
