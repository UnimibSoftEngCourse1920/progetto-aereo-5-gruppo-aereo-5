package gruppoaereo5.bookPlaneTicket.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gruppoaereo5.bookBackEnd.daoimpl.PrenotazioneDaoImpl;


@WebServlet("/cercaPrenotazione")
public class PrenotazioneController extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	    private PrenotazioneDaoImpl prenotazioneDaoImpl;

		
	    public void init() {
	    	prenotazioneDaoImpl = new PrenotazioneDaoImpl();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        response.sendRedirect("conferma.jsp");
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        try {
	            authenticate(request, response);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    } 

	    private void authenticate(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	    	String email =request.getParameter("email");
	    	String codicePrenotazione = request.getParameter("codiceprenotazione");

	        if (prenotazioneDaoImpl.validate(email, codicePrenotazione)) {
	            RequestDispatcher dispatcher = request.getRequestDispatcher("pagamento");
	            dispatcher.forward(request, response);
	        } else {
	        	System.out.println("Dati Errati!");
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("conferma");
	            dispatcher.forward(request, response);
	        }
	    }
    
}

