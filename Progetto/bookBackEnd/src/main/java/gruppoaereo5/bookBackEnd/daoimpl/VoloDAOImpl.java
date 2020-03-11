package gruppoaereo5.bookBackEnd.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gruppoaereo5.bookBackEnd.dao.VoloDAO;
import gruppoaereo5.bookBackEnd.dto.Filtro;
import gruppoaereo5.bookBackEnd.dto.Volo;


@Transactional
@Repository("VoloDAO")
public class VoloDAOImpl implements VoloDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Volo> voli = new ArrayList<>();
	
	static {
		
		Volo volo = new Volo();
		 volo.setCodice_volo("e1");
		 volo.setAereo("fisa");
		 volo.setCitta_partenza("Milano");
		 volo.setCitta_arrivo("Roma");
		 volo.setData_partenza("2019-02-12");
		 volo.setData_arrivo("2019-02-13");
		 volo.setOra_partenza("22:33");
		 volo.setOra_arrivo("22:33");
		 volo.setKmTratta(122.22);
		 volo.setPrezzo(33.3);
		 volo.setPuntiOttenuti(44);
		 
		 voli.add(volo);
		 
		 volo = new Volo();
		 volo.setCodice_volo("e1a");
		 volo.setAereo("fisadfaa");
		 volo.setCitta_partenza("Londra");
		 volo.setCitta_arrivo("Parigi");
		 volo.setData_partenza("2020-01-15");
		 volo.setData_arrivo("2020-01-15");
		 volo.setOra_partenza("22:33");
		 volo.setOra_arrivo("22:33");
		 volo.setKmTratta(122.22);
		 volo.setPrezzo(33.3);
		 volo.setPuntiOttenuti(4334);
		 
		 voli.add(volo);
		 
		 volo = new Volo();
		 volo.setCodice_volo("e1rr");
		 volo.setAereo("fi56765sa");
		 volo.setCitta_partenza("Mosca");
		 volo.setCitta_arrivo("New York");
		 volo.setData_partenza("2019-12-20");
		 volo.setData_arrivo("2019-12-21");
		 volo.setOra_partenza("22:33");
		 volo.setOra_arrivo("22:33");
		 volo.setKmTratta(122.22);
		 volo.setPrezzo(33.3);
		 volo.setPuntiOttenuti(4774);
		 
		 voli.add(volo);
		 
	}
	@Override
	public List<Volo> list(Filtro filtro) {
		List<Volo> voliCercati = new ArrayList<>();

		for(Volo volo : voli) {
			
			if((volo.getCitta_partenza().equalsIgnoreCase(filtro.getCittaPartenza())) 
				&&(volo.getCitta_arrivo().equalsIgnoreCase(filtro.getCittaArrivo()))
					&&(volo.getData_partenza().equalsIgnoreCase(filtro.getDataPartenza())))
						voliCercati.add(volo);
		}

		return voliCercati;
	}
	
	//controllare
	
	@Override
	@Transactional
	public boolean add(Volo volo) {
		try {
			//aggiunta voli dal database
			sessionFactory.getCurrentSession().persist(volo);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Volo get(String codiceVolo) {

		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Volo.class,String.valueOf(codiceVolo));			
			}
			catch(Exception ex) {		
				ex.printStackTrace();			
			}
			return null;
		}
	
	@Override
	public List<Volo> listVoli() {

		String selezionaVoli =  "FROM Volo";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selezionaVoli, Volo.class)
						.getResultList();
	
	}

	
}

