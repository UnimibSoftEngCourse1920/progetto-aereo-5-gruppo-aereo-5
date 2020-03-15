package gruppoaereo5.bookBackEnd.daoimpl;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import gruppoaereo5.bookBackEnd.config.HibernateUtil;
import gruppoaereo5.bookBackEnd.dao.PrenotazioneDAO;
import gruppoaereo5.bookBackEnd.dao.UserDAO;
import gruppoaereo5.bookBackEnd.dto.Prenotazione;
import gruppoaereo5.bookBackEnd.dto.User;

@Repository("prenotazioneDAO")
public class PrenotazioneDaoImpl implements PrenotazioneDAO{
	
	@Override
	public void savePrenotazione(Prenotazione prenotazione) {
		Transaction transaction = null;
        try (Session session = HibernateUtil
        				.getSessionFactory()
        				.openSession()) {
        	
            // start a transaction
            transaction = session.beginTransaction();
            // save the  object
            session.save(prenotazione);
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
	
	
	  public boolean validate(String email, String codicePrenotazione) {

	        Transaction transaction = null;
	        Prenotazione prenotazione = null;
	        User user = null;

	        try (Session session = HibernateUtil
	        					.getSessionFactory()
	        					.openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            
	            user = (User) session.createQuery("FROM User WHERE email = :email").setParameter("email", email)
	                    .uniqueResult();
	            
	            // get an  object    

	            prenotazione = (Prenotazione) session.createQuery("FROM Prenotazione WHERE utente = :utente").setParameter("utente", user.getId())
	            									 .uniqueResult();


	            if (prenotazione != null && prenotazione.getCodicePrenotazione().equals(codicePrenotazione)) {
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
