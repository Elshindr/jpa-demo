package fr.diginamic.banque.entites;


import javax.persistence.*;

@Embeddable
public class Adresse {

    private Integer id;

    private Integer numero;

    private String rue;

    private Integer cp;

    private String ville;

    public Adresse() {
    }

    public Adresse(Integer id, Integer numero, String rue, Integer cp, String ville) {
        this.id = id;
        this.numero = numero;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", numero=" + numero +
                ", rue='" + rue + '\'' +
                ", cp=" + cp +
                ", ville='" + ville + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
