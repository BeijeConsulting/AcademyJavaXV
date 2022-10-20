package it.beije.musicstore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "artista")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "genere")
    private String genere;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_artista")
//    private List<Canzone> canzoni;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_artista")
    private List<Album> albumArtista;

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

//    public List<Canzone> getCanzoni() {
//        return canzoni;
//    }
//
//    public void setCanzoni(List<Canzone> canzoni) {
//        this.canzoni = canzoni;
//    }

    public List<Album> getAlbumArtista() {
        return albumArtista;
    }

    public void setAlbumArtista(List<Album> albumArtista) {
        this.albumArtista = albumArtista;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", genere='" + genere + '\'' +
                ", albumArtista=" + albumArtista +
                '}';
    }
}
