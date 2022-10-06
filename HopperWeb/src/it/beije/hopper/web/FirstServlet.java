package it.beije.hopper.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first_servlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
    	
    	System.out.println("FirstServlet...");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doGet...");
		
		StringBuilder builder = new StringBuilder();
		builder.append("<!DOCTYPE html>" + 
				"<html><head><meta charset=\"ISO-8859-1\">" + 
				"<title>First Servlet</title></head>" + 
				"<body>" + 
				"CIAO HOPPER! Sono la vostra prima Servlet..." + 
				"</body>" + 
				"</html>");
		
		response.getWriter().append(builder.toString());
//		response.getWriter().append("Served at: ").append(LocalDateTime.now().toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		System.out.println("FirstServlet doPost...");
		System.out.println(fname);


		
		
		response.getWriter().append("fname : ").append(fname).append("<br/> lname : ").append(lname);
	}

}
