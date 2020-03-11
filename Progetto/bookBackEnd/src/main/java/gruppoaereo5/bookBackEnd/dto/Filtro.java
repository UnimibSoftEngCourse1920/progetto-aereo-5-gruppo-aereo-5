package gruppoaereo5.bookBackEnd.dto;

public class Filtro {
	
	private String cittaPartenza;
	private String cittaArrivo;
	private String dataPartenza;
	
	
	public String getDataPartenza() {
		return dataPartenza;
	}
	public void setDataPartenza(String dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	public String getCittaPartenza() {
		return cittaPartenza;
	}
	public void setCittaPartenza(String cittaPartenza) {
		this.cittaPartenza = cittaPartenza;
	}
	public String getCittaArrivo() {
		return cittaArrivo;
	}
	public void setCittaArrivo(String cittaArrivo) {
		this.cittaArrivo = cittaArrivo;
	}

	@Override
	public String toString() {
		return "Filtro [cittaPartenza=" + cittaPartenza + ", cittaArrivo=" + cittaArrivo
				+ ", dataPartenza=" + dataPartenza + "]";
	}


}
