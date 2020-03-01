package gruppoaereo5.bookBackEnd.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Volo {

	/*
	 * Private fields
	 */
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String codice_volo;
	
	private String aereo;
	private String citta_partenza;
	private String citta_arrivo;
	private Date data_partenza;
	private Date data_arrivo;
	private Date ora_partenza;
	private Date ora_arrivo;
	private double kmTratta;
	private double prezzo;
	private double puntiOttenuti;
	
	public String getCodice_volo() {
		return codice_volo;
	}
	public void setCodice_volo(String codice_volo) {
		this.codice_volo = codice_volo;
	}
	public String getAereo() {
		return aereo;
	}
	public void setAereo(String aereo) {
		this.aereo = aereo;
	}
	public String getCitta_partenza() {
		return citta_partenza;
	}
	public void setCitta_partenza(String citta_partenza) {
		this.citta_partenza = citta_partenza;
	}
	public String getCitta_arrivo() {
		return citta_arrivo;
	}
	public void setCitta_arrivo(String citta_arrivo) {
		this.citta_arrivo = citta_arrivo;
	}
	public Date getData_partenza() {
		return data_partenza;
	}
	public void setData_partenza(String data_partenza) {
		try {
			DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
			formatoData.setLenient(false);
			this.data_partenza = formatoData.parse(data_partenza);
		}catch (ParseException e) {
			System.out.println("Formato data non valido -> gg/mm/aa");
		}
	}
	public Date getData_arrivo() {
		return data_arrivo;
	}
	public void setData_arrivo(String data_arrivo) {
		try {
			DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
			formatoData.setLenient(false);
			this.data_arrivo = formatoData.parse(data_arrivo);
		}catch (ParseException e) {
			System.out.println("Formato data non valido -> gg/mm/aa");
		}
	}
	public Date getOra_partenza() {
		return ora_partenza;
	}
	public void setOra_partenza(String ora_partenza) {
		try {
			DateFormat formatoData = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.ITALY);
			formatoData.setLenient(false);
			this.ora_partenza = formatoData.parse(ora_partenza);
		}catch (ParseException e) {
			System.out.println("Formato ora non valido -> HH:mm");
		}
	}
	public Date getOra_arrivo() {
		return ora_arrivo;
	}
	public void setOra_arrivo(String ora_arrivo) {
		try {
			DateFormat formatoData = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.ITALY);
			formatoData.setLenient(false);
			this.ora_arrivo = formatoData.parse(ora_arrivo);
		}catch (ParseException e) {
			System.out.println("Formato ora non valido -> HH:mm");
		}
	}
	public double getKmTratta() {
		return kmTratta;
	}
	public void setKmTratta(double kmTratta) {
		this.kmTratta = kmTratta;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public double getPuntiOttenuti() {
		return puntiOttenuti;
	}
	public void setPuntiOttenuti(double puntiOttenuti) {
		this.puntiOttenuti = puntiOttenuti;
	}
	
	@Override
	public String toString() {
		return "Volo [codice_volo=" + codice_volo + ", aereo=" + aereo + ", citta_partenza=" + citta_partenza
				+ ", citta_arrivo=" + citta_arrivo + ", data_partenza=" + data_partenza + ", data_arrivo=" + data_arrivo
				+ ", ora_partenza=" + ora_partenza + ", ora_arrivo=" + ora_arrivo + ", kmTratta=" + kmTratta
				+ ", prezzo=" + prezzo + ", puntiOttenuti=" + puntiOttenuti + "]";
	}
	
	
	
}
