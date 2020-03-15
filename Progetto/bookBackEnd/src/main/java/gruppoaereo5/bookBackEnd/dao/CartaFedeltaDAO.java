package gruppoaereo5.bookBackEnd.dao;

import gruppoaereo5.bookBackEnd.dto.CartaFedelta;

public interface CartaFedeltaDAO {

	public void saveCartaFedelta(CartaFedelta cartaFedelta);
	public CartaFedelta getCartaFedelta(Integer id);
}
