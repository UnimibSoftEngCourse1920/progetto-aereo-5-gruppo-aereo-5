package gruppoaereo5.bookBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gruppoaereo5.bookBackEnd.config.HibernateUtil;
import gruppoaereo5.bookBackEnd.dao.VoloDAO;
import gruppoaereo5.bookBackEnd.dto.Filtro;
import gruppoaereo5.bookBackEnd.dto.Posto;
import gruppoaereo5.bookBackEnd.dto.Prenotazione;
import gruppoaereo5.bookBackEnd.dto.Volo;


@Transactional
@Repository("VoloDAO")
public class VoloDAOImpl implements VoloDAO {

	@Override
	public List<Volo> list() {
		String selezionaVoli =  "FROM Volo";
		
        Transaction transaction = null;
        try (Session session = HibernateUtil
        				.getSessionFactory()
        				.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            return session.createQuery(selezionaVoli, Volo.class)
            				.getResultList();
            
           
          //  session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public Volo get(String codiceVolo) {

		String selezionaVoli =  "FROM Volo WHERE codice_volo = :codice_volo";
		
		 Transaction transaction = null;
	        try (Session session = HibernateUtil
	        				.getSessionFactory()
	        				.openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            return session.createQuery(selezionaVoli,Volo.class)
	            		.setParameter("codice_volo",codiceVolo)
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
	
	@Override
	public List<Volo> listVoli(Filtro filtro) {

		String selezionaVoli =  "FROM Volo WHERE citta_partenza = :citta_partenza AND citta_arrivo = :citta_arrivo AND data_partenza = :data_partenza";
		
        Transaction transaction = null;
        try (Session session = HibernateUtil
        				.getSessionFactory()
        				.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            return session.createQuery(selezionaVoli, Volo.class)
            				.setParameter("citta_partenza", filtro.getCittaPartenza())
            					.setParameter("citta_arrivo", filtro.getCittaArrivo())
            						.setParameter("data_partenza", filtro.getDataPartenza())
            							.getResultList();
            
           
          //  session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
	}
	public int getPunti(Integer id) {
		 Transaction transaction = null;
			Volo volo=null;
			Prenotazione prenotazione = null;
			Posto posto =null;
			String pren=null;
			String post=null;
	        try (Session session = HibernateUtil
	        					.getSessionFactory()
	        					.openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an  object    	
	            prenotazione = (Prenotazione) session.createQuery("FROM Prenotazione WHERE utente = :id").setParameter("id", id).getSingleResult();
	            pren=prenotazione.getCodicePrenotazione();
	            
	            posto = (Posto) session.createQuery("FROM Posto WHERE prenotazione = :pren").setParameter("pren", pren).getSingleResult();
	            
	            post=posto.getVolo();
	            volo = (Volo) session.createQuery("FROM Volo WHERE codice_volo = :post ").setParameter("post", post).getSingleResult();	    								

				// commit transaction
				transaction.commit();
	           //  session.close();
	                } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return (int) volo.getPuntiOttenuti();
	    }
	}
	

