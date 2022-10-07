package it.beije.hopper.web.rubrica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rubrica")
public class Contatto {
	
	public Contatto() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "cognome")
	private String cognome;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "telefono")
	private String telefono;

	@Column(name = "email")
	private String email;

	@Column(name = "note")
	private String note;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", cognome : ").append(this.cognome)
				.append(", nome : ").append(this.nome)
				.append(", telefono : ").append(this.telefono)
				.append(", email : ").append(this.email)
				.append(", note : ").append(this.note).append(" }");
		
		return builder.toString();
	}
	
	public boolean isEmpy() {
		
		if(this.getId() < 0) return false;
		if(this.getCognome() != null) return false;
		if(this.getNome() != null) return false;
		if(this.getTelefono() != null) return false;
		if(this.getEmail() != null) return false;
		if(this.getNote() != null) return false;
		
		return true;
	}
	
	public Contatto returnCopy() {
		Contatto contatto = new Contatto();
		
		contatto.setId( this.getId() );
		contatto.setCognome( this.getCognome() );
		contatto.setNome( this.getNome() );
		contatto.setTelefono( this.getTelefono() );
		contatto.setEmail( this.getEmail() );
		contatto.setNote( this.getNote() );
		
		return contatto;
	}
}
