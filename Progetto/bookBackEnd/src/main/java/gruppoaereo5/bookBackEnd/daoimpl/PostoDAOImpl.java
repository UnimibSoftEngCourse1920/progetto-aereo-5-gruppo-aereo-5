package gruppoaereo5.bookBackEnd.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gruppoaereo5.bookBackEnd.dao.PostoDAO;
import gruppoaereo5.bookBackEnd.dto.Posto;

@Repository("postoDAO")
public class PostoDAOImpl implements PostoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Posto> posti = new ArrayList<>();
	
	@Override
	public List<Posto> list() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM posto", Posto.class)
					.getResultList();
	}

	@Override
	public Posto get(int postoID) {
		try {
			return sessionFactory.getCurrentSession()
					.get(Posto.class, Integer.valueOf(postoID));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Posto> listPostiLiberi(String volo) {
		String postiLiberiPerVolo = "FROM posti WHERE volo = :volo AND null =:prenotazione";
		return sessionFactory
				.getCurrentSession()
					.createQuery(postiLiberiPerVolo, Posto.class)
						.setParameter("volo", volo)
							.getResultList();
	}

}
