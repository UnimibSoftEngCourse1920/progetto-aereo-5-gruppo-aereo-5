package gruppoaereo5.bookPlaneTicket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gruppoaereo5.bookBackEnd.daoimpl.CartaFedeltaDAOImpl;
import gruppoaereo5.bookBackEnd.daoimpl.UserDaoImpl;
import gruppoaereo5.bookBackEnd.daoimpl.VoloDAOImpl;
import gruppoaereo5.bookBackEnd.dto.CartaFedelta;
import gruppoaereo5.bookBackEnd.dto.User;

@WebServlet("/aggiornaCartaFedele")
public class CartaFedeltaController extends HttpServlet{

	private static final long serialVersionUID = 1L;


protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	request.getRequestDispatcher("pagamento.jsp").forward(request, response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	CartaFedeltaDAOImpl cartafedeltaDAOImpl = new CartaFedeltaDAOImpl();
	VoloDAOImpl voloDAOImpl= new VoloDAOImpl();
	
	UserDaoImpl userDaoImpl=new UserDaoImpl();
	User user= new User();
	
	String username=request.getParameter("username"); //email utente
	
	
	user=userDaoImpl.getUserByEmail(username); //ho in user l'utente con email=username
	
	Integer id = user.getId(); //id utente
	
	String idString=id.toString(); //id utente in forma di stringa

	int punti=voloDAOImpl.getPunti(id); //metto in punti i punti del volo specifico
	
	int puntiCarta=cartafedeltaDAOImpl.getPuntiCarta(idString); //prendo i punti sulla carta
	CartaFedelta cartaFedelta=cartafedeltaDAOImpl.getCartaFedelta(id);
	String deviRimuovere = request.getParameter("deviRimuovere");
	
	if(deviRimuovere.contentEquals("1")) {
		if(puntiCarta < (punti*10)) {
			System.out.println("punti non sufficienti sulla carta");
			request.getRequestDispatcher("pagamento").forward(request, response);	
			return;
		}
		else {
			puntiCarta=puntiCarta-(punti*10);
		}
	}
	else {
		puntiCarta=puntiCarta+punti;
	}
	cartaFedelta.setPuntifedelta(puntiCarta);
	cartaFedelta.setUtente(idString);
	
	if (cartafedeltaDAOImpl.update(cartaFedelta)) {
		request.setAttribute("msg", "Successful");
	} else {
		request.setAttribute("msg", "Failed");
	}
	request.getRequestDispatcher("pagamentok").forward(request, response);
}

}