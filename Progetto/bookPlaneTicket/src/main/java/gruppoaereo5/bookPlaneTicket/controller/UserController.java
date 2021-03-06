package gruppoaereo5.bookPlaneTicket.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gruppoaereo5.bookBackEnd.config.SendEmail;
import gruppoaereo5.bookBackEnd.daoimpl.CartaFedeltaDAOImpl;
import gruppoaereo5.bookBackEnd.daoimpl.UserDaoImpl;
import gruppoaereo5.bookBackEnd.dto.CartaFedelta;
import gruppoaereo5.bookBackEnd.dto.User;
@WebServlet("/register")
public class UserController extends HttpServlet{
	 private UserDaoImpl userDaoImpl ;
	 private CartaFedeltaDAOImpl cartaFedeltaDaoImpl;
	 private SendEmail sm;

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 public void init() {
	        userDaoImpl = new UserDaoImpl();
	        cartaFedeltaDaoImpl = new CartaFedeltaDAOImpl();
	        sm = new SendEmail();
	        
	        
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        register(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        response.sendRedirect("registrati.jsp");
	    }
                
	    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String email = request.getParameter("email");
			String datanascita = request.getParameter("datanascita");
			String indirizzo = request.getParameter("indirizzo");
			String password = request.getParameter("password");
			String ultimoAcquisto = " ";
			boolean infedele = false;

	        User user = new User();
	        user.setEmail(email);
	        user.setNome(nome);
	        user.setCognome(cognome);
	        user.setIndirizzo(indirizzo);
	        user.setDataNascita(datanascita);
	        user.setPassword(password);
	        user.setUltimoAcquisto(ultimoAcquisto);
	        user.setInfedele(infedele);

	        userDaoImpl.saveUser(user);
	        String id=null;
	        id=Integer.toString(user.getId());
	        CartaFedelta cs = new CartaFedelta();	                
	        cs.setPuntifedelta(0);
	        cs.setUtente(id);
	        
	        cartaFedeltaDaoImpl.saveCartaFedelta(cs);
	        
	        sm.sendEmailRegistrazione(email, nome, cognome);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("registrazioneEffettuata");
	        dispatcher.forward(request, response);
	    }
}
	