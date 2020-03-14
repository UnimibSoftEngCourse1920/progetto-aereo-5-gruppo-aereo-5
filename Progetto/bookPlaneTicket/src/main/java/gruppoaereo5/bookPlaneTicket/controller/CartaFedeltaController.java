package gruppoaereo5.bookPlaneTicket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gruppoaereo5.bookBackEnd.daoimpl.CartaFedeltaDAOImpl;
import gruppoaereo5.bookBackEnd.daoimpl.VoloDAOImpl;
import gruppoaereo5.bookBackEnd.dto.CartaFedelta;

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
	CartaFedelta cartaFedelta = new CartaFedelta();
	VoloDAOImpl voloDAOImpl= new VoloDAOImpl();
	
	String idString=request.getParameter("id");
	int id= Integer.parseInt(request.getParameter("id"));
	int punti=voloDAOImpl.getPunti(idString);
	
	int puntiCarta=cartafedeltaDAOImpl.getPuntiCarta(idString);

	String deviRimuovere = request.getParameter("deviRimuovere");
	
	if(deviRimuovere.contentEquals("1")) {
		if(puntiCarta < (punti*10)) {
			System.out.println("punti non sufficienti sulla carta");
			request.getRequestDispatcher("pagamento").forward(request, response);	
		}
		else {
			puntiCarta=puntiCarta-(punti*10);
		}
	}
	else {
		puntiCarta=puntiCarta+punti;
	}
	cartaFedelta.setId(id);
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