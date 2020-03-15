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
            // save the  object
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

	public boolean update(CartaFedelta cartaFedelta) {
		boolean result = true;
		Transaction transaction = null;
		try (Session session = HibernateUtil
						.getSessionFactory()
						.openSession()){
			 // start a transaction
			transaction = session.beginTransaction();
			// update the  object
			session.update(cartaFedelta);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			result = false;
		} 
		return result;
	}
	@Override
    public CartaFedelta getCartaFedelta(Integer id) {
        Transaction transaction = null;
        CartaFedelta cartaFedelta=null;

        try (Session session = HibernateUtil
                            .getSessionFactory()
                            .openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an  object
            cartaFedelta = (CartaFedelta) session.createQuery("FROM CartaFedelta WHERE utente = :id").setParameter("id", id.toString()).getSingleResult();

            // commit transaction
            transaction.commit();
           //  session.close();
                } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return  cartaFedelta;
    }
	
	public int getPuntiCarta(String id) {
		 Transaction transaction = null;
			CartaFedelta cartaFedelta=null;

	        try (Session session = HibernateUtil
	        					.getSessionFactory()
	        					.openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an  object    	
	            cartaFedelta = (CartaFedelta) session.createQuery("FROM CartaFedelta WHERE utente = :id").setParameter("id", id).getSingleResult();

				// commit transaction
				transaction.commit();
	           //  session.close();
	                } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return  cartaFedelta.getPuntifedelta();
	    }
	
	
}
