package it.beije.musicstore.model;

import javax.persistence.*;

@Entity
public class Artista {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "genere")
    private String genere;

    //Getter e setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder()
                .append("{id: ").append(this.id)
                .append(",nome: ").append(this.nome)
                .append(",genere: ").append(this.genere);
        return builder.toString();
    }
}
