package gruppoaereo5.bookBackEnd.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gruppoaereo5.bookBackEnd.dao.UserDAO;
import gruppoaereo5.bookBackEnd.dto.Carrello;
import gruppoaereo5.bookBackEnd.dto.User;

@Repository(" ")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		try {			
			sessionFactory.getCurrentSession().persist(user);			
			return true;
		}
		catch(Exception ex) {
			return false;
		
	}
	}

	@Override
	public boolean updateCarrello(Carrello carrello) {
		try {			
			sessionFactory.getCurrentSession().update(carrello);			
			return true;
		}
		catch(Exception ex) {
			return false;
		
	}
	}

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email  = :email";
		
		try {
			return sessionFactory.getCurrentSession()	
					.createQuery(selectQuery, User.class)
						.setParameter("email", email)
						.getSingleResult();		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	


}
