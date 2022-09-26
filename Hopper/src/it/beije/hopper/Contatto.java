package it.beije.hopper;

public class Contatto {
	private String cognome;
	private String nome;
	private String telefono;
	private String email;
	private String note;

	private int id;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
				.append("{ID: ").append(this.id)
				.append(", Cognome: ").append(this.cognome)
				.append(", Nome: ").append(this.nome)
				.append(", Telefono: ").append(this.telefono)
				.append(", E-Mail: ").append(this.email)
			    .append(", Note: ").append(this.note).append("}\n");
		
		return builder.toString();
	}
}
