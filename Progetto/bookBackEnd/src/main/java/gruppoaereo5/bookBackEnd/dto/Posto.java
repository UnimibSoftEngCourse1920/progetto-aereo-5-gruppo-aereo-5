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
	private int lettera;
	private int prenotazione;
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
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getLettera() {
		return lettera;
	}
	public void setLettera(int lettera) {
		this.lettera = lettera;
	}
	public int getPrenotazione() {
		return prenotazione;
	}
	public void setPrenotazione(int prenotazione) {
		this.prenotazione = prenotazione;
	}
	public String getVolo() {
		return volo;
	}
	public void setVolo(String volo) {
		this.volo = volo;
	}
}
