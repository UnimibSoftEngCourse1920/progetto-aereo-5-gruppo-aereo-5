package gruppoaereo5.bookBackEnd.dao;

import gruppoaereo5.bookBackEnd.dto.User;

public interface UserDAO {
	
	public void saveUser(User user);
	User getUserByEmail(String email);
}
