package it.beije.hopper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "recapiti")
public class Recapiti {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "rubrica_id")
	private int rubrica_id;

	@Column(name = "recapito")
	private String recapito;
	
	@Column(name = "tipo")
	private String tipo;

	@Column(name = "descr")
	private String descr;

	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRubrica_id() {
		return rubrica_id;
	}
	public void setRubrica_id(int rubrica_id) {
		this.rubrica_id = rubrica_id;
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
	
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", rubrica_id : ").append(this.rubrica_id)
				.append(", recapito : ").append(this.recapito)
				.append(", tipo : ").append(this.tipo)
				.append(", descr : ").append(this.descr).append(" } \n");
		
		return builder.toString();
	}
}
