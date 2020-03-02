package gruppoaereo5.bookBackEnd.dto;

import java.time.LocalDate;

public class FiltroDTO {

    private String partenza;
    private String arrivo;
    private LocalDate dataPartenza;
    private LocalDate dataRitorno;
    private Integer nPasseggeri;


    public String getPartenza() {
        return partenza;
    }

    public Integer getnPasseggeri() {
		return nPasseggeri;
	}

	public void setnPasseggeri(Integer nPasseggeri) {
		this.nPasseggeri = nPasseggeri;
	}

	public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public String getArrivo() {
        return arrivo;
    }

    public void setArrivo(String arrivo) {
        this.arrivo = arrivo;
    }


    

    public LocalDate getDataPartenza() {
        return dataPartenza;
    }

    public void setDataPartenza(LocalDate dataPartenza) {
        this.dataPartenza = dataPartenza;
    }

    public LocalDate getDataRitorno() {
        return dataRitorno;
    }

    public void setDataRitorno(LocalDate dataRitorno) {
        this.dataRitorno = dataRitorno;
    }



}