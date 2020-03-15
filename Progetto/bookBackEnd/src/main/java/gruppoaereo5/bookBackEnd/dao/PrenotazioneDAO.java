package gruppoaereo5.bookBackEnd.dao;
import gruppoaereo5.bookBackEnd.dto.Prenotazione;

public interface PrenotazioneDAO {
	public void savePrenotazione(Prenotazione prenotazione);
	Boolean controlloPrenotazioni(int idUtente,String codiceVolo);
}
