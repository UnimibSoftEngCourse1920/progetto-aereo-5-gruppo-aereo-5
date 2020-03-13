package gruppoaereo5.bookBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gruppoaereo5.bookBackEnd.config.HibernateUtil;
import gruppoaereo5.bookBackEnd.dao.PostoDAO;
import gruppoaereo5.bookBackEnd.dto.Posto;

@Transactional
@Repository("postoDAO")
public class PostoDAOImpl implements PostoDAO{

	@Override
	public List<Posto> list() {
		String selezionaPosti =  "FROM Posto";
		
        Transaction transaction = null;
        try (Session session = HibernateUtil
        				.getSessionFactory()
        				.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            return session.createQuery(selezionaPosti, Posto.class)
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
	public Posto get(int postoID) {
		String selezionaPosti =  "FROM Posto WHERE idPosto = :idPosto";
		
		Transaction transaction = null;
        try (Session session = HibernateUtil
        				.getSessionFactory()
        				.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            return session.createQuery(selezionaPosti,Posto.class)
            		.setParameter("idPosto",postoID)
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
	public List<Posto> listPostiLiberi(String codiceVolo) {
		String postiLiberiPerVolo = "FROM Posto WHERE volo = :volo AND prenotazione = :prenotazione";
		
		Transaction transaction = null;
        try (Session session = HibernateUtil
        				.getSessionFactory()
        				.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            return session.createQuery(postiLiberiPerVolo, Posto.class)
    					.setParameter("volo", codiceVolo)
    						.setParameter("prenotazione", null)
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
	
}
