package it.beije.hopper;

public class Finanze {
	private String nome;

	private Float importo;

	private Integer quantita;

	private Character operazione;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getImporto() {
		return importo;
	}

	public void setImporto(Float importo) {
		this.importo = importo;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public Character getOperazione() {
		return operazione;
	}

	public void setOperazione(Character operazione) {
		this.operazione = operazione;
	}

	@Override
	public String toString() {
		return "Finanze{" +
				"nome='" + nome + '\'' +
				", importo=" + importo +
				", quantita=" + quantita +
				", operazione=" + operazione +
				'}';
	}
}
