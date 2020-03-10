package gruppoaereo5.bookBackEnd.daoimpl;


import gruppoaereo5.bookBackEnd.config.HibernateUtil;

import gruppoaereo5.bookBackEnd.dto.User;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDaoImpl {

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
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
