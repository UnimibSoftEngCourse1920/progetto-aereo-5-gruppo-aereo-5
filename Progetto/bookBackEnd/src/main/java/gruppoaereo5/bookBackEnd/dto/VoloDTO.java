package gruppoaereo5.bookBackEnd.dto;

import java.util.Date;

public class VoloDTO {

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

	public void setData_partenza(Date data_partenza) {
		this.data_partenza = data_partenza;
	}

	public Date getData_arrivo() {
		return data_arrivo;
	}

	public void setData_arrivo(Date data_arrivo) {
		this.data_arrivo = data_arrivo;
	}

	public Date getOra_partenza() {
		return ora_partenza;
	}

	public void setOra_partenza(Date ora_partenza) {
		this.ora_partenza = ora_partenza;
	}

	public Date getOra_arrivo() {
		return ora_arrivo;
	}

	public void setOra_arrivo(Date ora_arrivo) {
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

}
