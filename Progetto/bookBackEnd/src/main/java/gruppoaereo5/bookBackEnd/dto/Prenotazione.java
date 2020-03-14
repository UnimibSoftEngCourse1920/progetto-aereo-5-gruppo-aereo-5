package gruppoaereo5.bookBackEnd.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prenotazione")
public class Prenotazione implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
	@Column(name = "codiceprenotazione")
	private String codicePrenotazione;
    
	@Column(name = "datascadenza")
	private String dataScadenza;
	
	@Column(name = "dataprenotazione")
	private String dataPrenotazione;
	
	@Column(name = "penalemodifica")
	private Double penaleModifica;
	
	@Column(name = "utente")
	private int utente ;

	

	public String getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(String dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public Double getPenaleModifica() {
		return penaleModifica;
	}

	public void setPenaleModifica(Double penaleModifica) {
		this.penaleModifica = penaleModifica;
	}

	public String getCodicePrenotazione() {
		return codicePrenotazione;
	}

	public void setCodicePrenotazione(String codicePrenotazione) {
		this.codicePrenotazione = codicePrenotazione;
	}

	public int getUtente() {
		return utente;
	}

	public void setUtente(int utente) {
		this.utente = utente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

