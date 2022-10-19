package it.beije.hopper.rubrica.model;

import javax.persistence.*;


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


	@Override
	public String toString() {
		return "Contatto{" +
				"id=" + id +
				", cognome='" + cognome + '\'' +
				", nome='" + nome + '\'' +
				", telefono='" + telefono + '\'' +
				", email='" + email + '\'' +
				", note='" + note + '\'' +
				'}';
	}
}
