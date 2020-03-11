package gruppoaereo5.bookBackEnd.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Biglietto")
public class Biglietto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBiglietto")
	private int id;
	
	@Column(name = "NomePasseggero")
	private String nome;
	
	@Column(name = "CognomePasseggero")
	private String cognome;
	
	@Column(name = "DataNascita")
	private Date dataNascita;
	
	@Column(name = "prenotazione")
	private int prenotazione;
	
	@Column(name = "utente")
	private int utente;

	@Override
	public String toString() {
		return "Biglietto [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", prenotazione=" + prenotazione + ", utente=" + utente + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public int getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(int prenotazione) {
		this.prenotazione = prenotazione;
	}

	public int getUtente() {
		return utente;
	}

	public void setUtente(int utente) {
		this.utente = utente;
	}

	public Biglietto() {
	}
	
}
