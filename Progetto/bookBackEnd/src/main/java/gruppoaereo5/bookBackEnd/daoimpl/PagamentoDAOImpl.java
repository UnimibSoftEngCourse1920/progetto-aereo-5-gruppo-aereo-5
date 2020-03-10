package gruppoaereo5.bookBackEnd.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import gruppoaereo5.bookBackEnd.config.HibernateUtil;
import gruppoaereo5.bookBackEnd.dao.PagamentoDAO;
import gruppoaereo5.bookBackEnd.dto.Pagamento;

public class PagamentoDAOImpl implements PagamentoDAO {

	@Override
	public void effettuaPagamento(Pagamento pagamento) {
		Transaction transaction = null;
        try (Session session = HibernateUtil
        				.getSessionFactory()
        				.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(pagamento);
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
