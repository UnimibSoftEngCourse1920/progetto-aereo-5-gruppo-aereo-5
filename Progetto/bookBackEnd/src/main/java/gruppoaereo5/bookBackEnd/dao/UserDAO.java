package gruppoaereo5.bookBackEnd.dao;
import java.util.List;

import gruppoaereo5.bookBackEnd.dto.Carrello;
import gruppoaereo5.bookBackEnd.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	boolean addCarrello(Carrello carrello);


}
