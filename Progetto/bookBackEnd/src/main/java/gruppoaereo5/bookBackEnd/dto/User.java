package gruppoaereo5.bookBackEnd.dto;


import java.io.Serializable;






import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "utente")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
    
	@Column(name = "email")
	private String email;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "datanascita")
	private String dataNascita;
	
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getUltimoAcquisto() {
		return ultimoAcquisto;
	}
	public void setUltimoAcquisto(String ultimoAcquisto) {
		this.ultimoAcquisto = ultimoAcquisto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Column(name = "ultimoAcquisto")
	private String ultimoAcquisto;
	
	@Column(name = "Indirizzocasa")
	private String indirizzo;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "infedele")	
	private boolean infedele;

	public boolean getInfedele() {
		return infedele;
	}
	public void setInfedele(boolean infedele) {
		this.infedele = infedele;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", dataNascita="
				+ dataNascita + ", password=" + password + ", confirmPassword=" + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	

}
