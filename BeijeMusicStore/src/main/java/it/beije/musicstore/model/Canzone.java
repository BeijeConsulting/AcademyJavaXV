package it.beije.musicstore.model;

import javax.persistence.*;

@Entity
@Table(name = "canzone")
public class Canzone {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_artista")
    private Integer id_artista;

    @Column(name = "genere")
    private String genere;

    //Getter e setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_artista() {
        return id_artista;
    }

    public void setId_artista(Integer id_artista) {
        this.id_artista = id_artista;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder()
                .append("id: ").append(this.id)
                .append(",id_artista: ").append(this.id_artista)
                .append(",genere:").append(this.genere);
        return builder.toString();
    }


}
