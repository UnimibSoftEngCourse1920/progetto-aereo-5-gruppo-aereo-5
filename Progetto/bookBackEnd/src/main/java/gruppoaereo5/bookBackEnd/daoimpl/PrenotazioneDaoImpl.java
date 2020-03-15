package gruppoaereo5.bookBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import gruppoaereo5.bookBackEnd.config.HibernateUtil;
import gruppoaereo5.bookBackEnd.dao.PrenotazioneDAO;
import gruppoaereo5.bookBackEnd.dto.Posto;
import gruppoaereo5.bookBackEnd.dto.Prenotazione;
import gruppoaereo5.bookBackEnd.dto.User;

@Repository("prenotazioneDAO")
public class PrenotazioneDaoImpl implements PrenotazioneDAO {

	@Override
	public void savePrenotazione(Prenotazione prenotazione) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start a transaction
			transaction = session.beginTransaction();
			// save the object
			session.save(prenotazione);
			// commit transaction
			transaction.commit();
			// session.close();
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
		int utente;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an object

			user = (User) session.createQuery("FROM User WHERE email = :email").setParameter("email", email)
					.uniqueResult();

			utente = user.getId();

			prenotazione = (Prenotazione) session.createQuery("FROM Prenotazione WHERE utente = :utente")
					.setParameter("utente", utente).uniqueResult();

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

	@Override
	public Boolean controlloPrenotazioni(int idUtente, String codiceVolo) {

		String selezionaPosti = "FROM Posto WHERE volo = :codiceVolo AND prenotazione IS NOT NULL";
		String selezionePrenotazioni = "FROM Prenotazione WHERE utente = :utente";
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			List<Posto> posti = session.createQuery(selezionaPosti, Posto.class).setParameter("codiceVolo", codiceVolo)
					.getResultList();
			List<Prenotazione> pren = session.createQuery(selezionePrenotazioni, Prenotazione.class)
					.setParameter("utente", idUtente).getResultList();
			Boolean prenotato = false;
			for (Prenotazione prenotazione : pren) {
				for (Posto posto : posti) {
					if (prenotazione.getCodicePrenotazione().equals(posto.getPrenotazione()))
						prenotato = true;
				}
			}
			
			return prenotato;
			// session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

}
