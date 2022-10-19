package it.beije.rubrica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "recapiti")
public class Recapito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "rubrica_id")
	private int rubricaId;

	@Column(name = "recapito")
	private String recapito;
	
	@Column(name = "tipo")
	private String tipo;

	@Column(name = "descrizione")
	private String descrizione;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRubrica_id() {
		return rubricaId;
	}
	public void setRubrica_id(int rubrica_id) {
		this.rubricaId = rubrica_id;
	}
	
	public String getRecapito() {
		return recapito;
	}
	public void setRecapito(String recapito) {
		this.recapito = recapito;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", rubrica_id : ").append(this.rubricaId)
				.append(", recapito: ").append(this.recapito)
				.append(", tipo : ").append(this.tipo)
				.append(", descrizione : ").append(this.descrizione);
		
		return builder.toString();
	}
	
}
