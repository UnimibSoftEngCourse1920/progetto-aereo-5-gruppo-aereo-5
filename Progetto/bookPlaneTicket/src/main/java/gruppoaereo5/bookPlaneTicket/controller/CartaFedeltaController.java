package gruppoaereo5.bookPlaneTicket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gruppoaereo5.bookBackEnd.daoimpl.CartaFedeltaDAOImpl;
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
	
	//String id=request.getParameter("id");
	//String kmvolo=request.getParameter("kmvolo");
	int id= Integer.parseInt(request.getParameter("id"));
	
	cartaFedelta.setId(id);
	cartaFedelta.setPuntifedelta(20);
	cartaFedelta.setUtente(id);
	

	//product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
	if (cartafedeltaDAOImpl.update(cartaFedelta)) {
		request.setAttribute("msg", "Successful");
	} else {
		request.setAttribute("msg", "Failed");
	}
	request.getRequestDispatcher("pagamentok").forward(request, response);
}

}