package gruppoaereo5.bookBackEnd.daoimpl;


import org.hibernate.Session;
import org.hibernate.Transaction;

import gruppoaereo5.bookBackEnd.config.HibernateUtil;
import gruppoaereo5.bookBackEnd.dao.UserDAO;
import gruppoaereo5.bookBackEnd.dto.User;


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
    
    
}
