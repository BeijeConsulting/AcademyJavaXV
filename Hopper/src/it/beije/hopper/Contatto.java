package it.beije.hopper;

public class Contatto {
	private String cognome;
	private String nome;
	private String telefono;
	private String email;
	private String note;
	
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
		return "{ cognome : " + this.cognome +
				", nome : " + this.nome +
				", telefono : " + this.telefono +
				", email : " + this.email +
				", note : " + this.note + " }";
	}
	
}
