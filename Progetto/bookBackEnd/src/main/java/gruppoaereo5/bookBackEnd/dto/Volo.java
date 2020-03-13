package gruppoaereo5.bookBackEnd.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "VOLO")
public class Volo {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String codice_volo;
	
	private String aereo;
	@Column(name = "città_partenza")
	private String citta_partenza;
	@Column(name = "città_arrivo")
	private String citta_arrivo;
	private String data_partenza;
	private String data_arrivo;
	private String ora_partenza;
	private String ora_arrivo;
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
	
	public String getData_partenza() {
		return data_partenza;
	}
	public void setData_partenza(String data_partenza) {
		this.data_partenza = data_partenza;
	}
	
	public String getData_arrivo() {
		return data_arrivo;
	}
	public void setData_arrivo(String data_arrivo) {
		this.data_arrivo = data_arrivo;
	}
	
	public String getOra_partenza() {
		return ora_partenza;
	}
	public void setOra_partenza(String ora_partenza) {
		this.ora_partenza = ora_partenza;
	}
	
	public String getOra_arrivo() {
		return ora_arrivo;
	}
	public void setOra_arrivo(String ora_arrivo) {
		this.ora_arrivo = ora_arrivo;
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
