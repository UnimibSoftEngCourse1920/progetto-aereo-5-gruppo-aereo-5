package gruppoaereo5.bookBackEnd.dao;
import java.util.List;

import gruppoaereo5.bookBackEnd.dto.Carrello;
import gruppoaereo5.bookBackEnd.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	User getByEmail(String email);
	boolean updateCarrello(Carrello carrello);


}
