package gruppoaereo5.bookBackEnd.dao;

import java.util.List;

import gruppoaereo5.bookBackEnd.dto.Filtro;
import gruppoaereo5.bookBackEnd.dto.Volo;

public interface VoloDAO {

	Volo get(String codiceVolo);
	List<Volo> list();
	List<Volo> listVoli(Filtro filtro);
	
}
