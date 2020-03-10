package gruppoaereo5.bookBackEnd.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pagamento")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idPagamento")
	private int id;
	
	//controllare se float o double
	@Column(name = "importo")
	private float importo;
	
	@Column(name = "cartaFedelta")
	private int cartaFedelta;
	
	@Column(name = "prenotazione")
	private int prenotazione;

	
	public Pagamento() {
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", importo=" + importo + ", cartaFedelta=" + cartaFedelta + ", prenotazione="
				+ prenotazione + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getImporto() {
		return importo;
	}

	public void setImporto(float importo) {
		this.importo = importo;
	}

	public int getCartaFedelta() {
		return cartaFedelta;
	}

	public void setCartaFedelta(int cartaFedelta) {
		this.cartaFedelta = cartaFedelta;
	}

	public int getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(int prenotazione) {
		this.prenotazione = prenotazione;
	}


}
