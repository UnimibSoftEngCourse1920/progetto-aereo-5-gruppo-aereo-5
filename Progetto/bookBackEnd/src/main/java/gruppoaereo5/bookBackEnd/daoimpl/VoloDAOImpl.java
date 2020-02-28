package gruppoaereo5.bookBackEnd.daoimpl;

import java.util.ArrayList;
import java.util.List;

import gruppoaereo5.bookBackEnd.dao.VoloDAO;
import gruppoaereo5.bookBackEnd.dto.Volo;

public class VoloDAOImpl implements VoloDAO {

	private static List<Volo> voli = new ArrayList<>();
	
	static {
		
		Volo volo = new Volo();
		 volo.setCodice_volo("e1");
		 volo.setAereo("fisa");
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

}
