package gruppoaereo5.bookBackEnd.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CartaFedeltà")
public class CartaFedelta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCartaFedeltà")
	private int id;
	
	@Column(name = "puntiTessera")
	private int puntifedelta;
	
	@Column(name = "utente")
	private int utente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPuntifedelta() {
		return puntifedelta;
	}

	public void setPuntifedelta(int puntifedelta) {
		this.puntifedelta = puntifedelta;
	}

	public int getUtente() {
		return utente;
	}

	public void setUtente(int utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "CartaFedelta [id=" + id + ", puntifedelta=" + puntifedelta + ", utente=" + utente + "]";
	}

}
