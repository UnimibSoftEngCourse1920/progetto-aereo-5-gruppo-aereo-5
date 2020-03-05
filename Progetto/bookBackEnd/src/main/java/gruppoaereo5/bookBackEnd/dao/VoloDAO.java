package gruppoaereo5.bookBackEnd.dao;

import java.util.List;

import gruppoaereo5.bookBackEnd.dto.Volo;

public interface VoloDAO {

	Volo get(int voloId);
	List<Volo> list();
	
	//controllare
	boolean add(Volo volo);
	
	List<Volo> listVoli();
}
