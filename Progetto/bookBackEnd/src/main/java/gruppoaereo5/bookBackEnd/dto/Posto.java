package gruppoaereo5.bookBackEnd.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPosto;
	
	private int fila;
	private String lettera;
	private String prenotazione;
	private String volo;
	
	public int getIdPosto() {
		return idPosto;
	}
	public void setIdPosto(int idPosto) {
		this.idPosto = idPosto;
	}
	public int getFila() {
		return fila;
	}
	public String getLettera() {
		return lettera;
	}
	public void setLettera(String lettera) {
		this.lettera = lettera;
	}
	public String getPrenotazione() {
		return prenotazione;
	}
	public void setPrenotazione(String prenotazione) {
		this.prenotazione = prenotazione;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}

	public String getVolo() {
		return volo;
	}
	public void setVolo(String volo) {
		this.volo = volo;
	}
}
