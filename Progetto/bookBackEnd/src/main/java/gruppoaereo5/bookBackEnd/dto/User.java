package gruppoaereo5.bookBackEnd.dto;


import java.io.Serializable;




import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

//import org.hibernate.validator.constraints.NotBlank;

@Entity

@Table(name = "UTENTE")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//@NotBlank(message = "Inserisci nome")
	@Column(name = "nome")
	private String nome;
	//@NotBlank(message = "Inserisci cognome")
	@Column(name = "cognome")
	private String cognome;
//	@NotBlank(message = "Inserisci mail")	
	private String email;
	//@NotBlank(message = "Inserisci data di nascita")
	@Column(name = "data_nascita")
	private Date dataNascita;
	@Column(name = "Indirizzo")
	private String indirizzo;
	//	@NotBlank(message = "Inserisci password")
	private String password;
	private String confermaPassword;
	
	@OneToOne(mappedBy ="user", cascade = CascadeType.ALL)

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", dataNascita="
				+ dataNascita + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
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
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Transient
	private String confirmPassword;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getConfermaPassword() {
		return confermaPassword;
	}
	public void setConfermaPassword(String confermaPassword) {
		this.confermaPassword = confermaPassword;
	}
	

}
