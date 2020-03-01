package gruppoaereo5.bookBackEnd.daoimpl;

import java.util.ArrayList;
import java.util.List;

//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import gruppoaereo5.bookBackEnd.dao.VoloDAO;
import gruppoaereo5.bookBackEnd.dto.Volo;


@Repository("voloDAO")
public class VoloDAOImpl implements VoloDAO {

	@Autowired
	//private SessionFactory sessionFactory;
	
	private static List<Volo> voli = new ArrayList<>();
	
	static {
		
		Volo volo = new Volo();
		 volo.setCodice_volo("e1");
		 volo.setAereo("fisa");
		 volo.setCitta_partenza("Milano");
		 volo.setCitta_arrivo("Roma");
		 volo.setData_partenza("12/02/1255");
		 volo.setData_arrivo("12/02/1255");
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
		 volo.setData_partenza("12/02/1255");
		 volo.setData_arrivo("12/02/1255");
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
		 volo.setData_partenza("12/10/1255");
		 volo.setData_arrivo("12/10/1255");
		 volo.setOra_partenza("22:33");
		 volo.setOra_arrivo("22:33");
		 volo.setKmTratta(122.22);
		 volo.setPrezzo(33.3);
		 volo.setPuntiOttenuti(4774);
		 
		 voli.add(volo);
		 
	}
	@Override
	public List<Volo> list() {
		// TODO Auto-generated method stub
		return voli;
	}
	
	//controllare
	/*
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
	}*/

}
