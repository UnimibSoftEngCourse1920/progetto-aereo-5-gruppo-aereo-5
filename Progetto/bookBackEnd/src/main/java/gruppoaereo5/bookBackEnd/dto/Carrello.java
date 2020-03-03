package gruppoaereo5.bookBackEnd.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Carrello {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	@Column(name = "id_utente")
	private double idUtente;
	public double getIdUtente() {
		return idUtente;
	}


	@Column(name = "totale")
	private double totale;
//	@Column(name = "cart_lines")
//	private int cartLines;
	
	public Carrello() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Carrello [id=" + id + ", idUtente=" + idUtente + ", totale=" + totale + "]";
	}

	public void setIdUtente(double idUtente) {
		this.idUtente = idUtente;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

}
