package it.beije.hopper.rubrica.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "recapiti")
public class Recapito {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "recapito")
    private String recapito;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descrizione")
    private String desc;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rubrica_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Contatto contatto;

    public Contatto getContatto() {
        return contatto;
    }

    public void setContatto(Contatto contatto) {
        this.contatto = contatto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Recapito{" +
                "id=" + id +
                ", contatto='" + contatto.getCognome() + " " + contatto.getNome() + '\'' +
                ", recapito='" + recapito + '\'' +
                ", tipo='" + tipo + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
