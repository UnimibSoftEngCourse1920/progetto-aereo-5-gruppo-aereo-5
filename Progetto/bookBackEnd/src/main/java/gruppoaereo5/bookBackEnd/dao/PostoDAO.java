package gruppoaereo5.bookBackEnd.dao;

import java.util.List;

import gruppoaereo5.bookBackEnd.dto.Posto;

public interface PostoDAO {
	List<Posto> list();
	
	Posto get(int postoID);
	
	List<Posto> listPostiLiberi(String volo);
	public void update(Posto posto);
	
}
