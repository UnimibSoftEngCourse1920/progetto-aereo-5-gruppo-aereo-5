package gruppoaereo5.bookBackEnd.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import gruppoaereo5.bookBackEnd.config.HibernateUtil;
import gruppoaereo5.bookBackEnd.dao.CartaFedeltaDAO;
import gruppoaereo5.bookBackEnd.dto.CartaFedelta;


public class CartaFedeltaDAOImpl implements CartaFedeltaDAO {

	@Override
    public void saveCartaFedelta(CartaFedelta cartaFedelta) {
        Transaction transaction = null;
        try (Session session = HibernateUtil
        				.getSessionFactory()
        				.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(cartaFedelta);
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
