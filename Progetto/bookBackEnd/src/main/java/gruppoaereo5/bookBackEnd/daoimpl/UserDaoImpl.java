package gruppoaereo5.bookBackEnd.daoimpl;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import gruppoaereo5.bookBackEnd.config.HibernateUtil;
import gruppoaereo5.bookBackEnd.dao.UserDAO;
import gruppoaereo5.bookBackEnd.dto.User;

@Repository("userDAO")
public class UserDaoImpl implements UserDAO{

    @Override
    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil
        				.getSessionFactory()
        				.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
          //  session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
    }

	@Override
	public User getUserByEmail(String email) {
		String selezionaUtente = "FROM User WHERE email = :email";
		
		Transaction transaction = null;
        try (Session session = HibernateUtil
        				.getSessionFactory()
        				.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            return session.createQuery(selezionaUtente,User.class)
            			.setParameter("email",email)
            				.uniqueResult();
            
            //  session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
	}
    
    

	public boolean validate(String email, String password) {
		Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (User) session.createQuery("FROM User U WHERE U.email = :email").setParameter("email", email)
                .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
        
	}

}
