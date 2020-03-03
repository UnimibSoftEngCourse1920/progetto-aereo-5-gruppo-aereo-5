package gruppoaereo5.bookBackEnd.daoimpl;

import gruppoaereo5.bookBackEnd.dao.UserDAO;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gruppoaereo5.bookBackEnd.dto.Carrello;
import gruppoaereo5.bookBackEnd.dto.User;

@Repository(" ")
@Transactional
public interface UserDAOImpl extends UserDAO {

	@Override
	default boolean addUser(User user) {
	/*	try {			
			sessionFactory.getCurrentSession().persist(user);			
			return true;
		}
		catch(Exception ex) {
			return false;
		
	}*/
		return false;
	}

	@Override
	default boolean addCarrello(Carrello carrello) {
	/*	try {			
			sessionFactory.getCurrentSession().persist(user);			
			return true;
		}
		catch(Exception ex) {
			return false;
		
	}*/
		return false;
	}
	
	//@Autowired
	//private SessionFactory sessionFactory;

}
