package gruppoaereo5.bookBackEnd.daoimpl;
import org.hibernate.Session;
import org.hibernate.Transaction;


import gruppoaereo5.bookBackEnd.config.HibernateUtil;
import gruppoaereo5.bookBackEnd.dao.PrenotazioneDAO;
import gruppoaereo5.bookBackEnd.dto.Prenotazione;

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
	
	
	  public boolean validate(String utente, String codicePrenotazione) {

	        Transaction transaction = null;
	        Prenotazione prenotazione = null;
	        try (Session session = HibernateUtil
	        					.getSessionFactory()
	        					.openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an  object    
	            prenotazione = (Prenotazione) session.createQuery("FROM Prenotazione WHERE utente = :utente").setParameter("utente", utente)
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
