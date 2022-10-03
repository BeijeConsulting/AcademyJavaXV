package it.beije.hopper;

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
	private String rubrica_id;

	@Column(name = "recapito")
	private String recapito;
	
	@Column(name = "tipo")
	private String tipo;

	@Column(name = "label")
	private String label;

	
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getRubrica_id() {
		return rubrica_id;
	}




	public void setRubrica_id(String rubrica_id) {
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




	public String getLabel() {
		return label;
	}




	public void setLabel(String label) {
		this.label = label;
	}




	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", rubrica_id : ").append(this.rubrica_id)
				.append(", recapito : ").append(this.recapito)
				.append(", tipo : ").append(this.tipo)
				.append(", label : ").append(this.label).append(" }");
		
		return builder.toString();
	}
}

