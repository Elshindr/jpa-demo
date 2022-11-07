package fr.diginamic.recensement.entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "habitants")
public class Habitant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="NOM")
    private String nom;

    @Column(name="PRENOM")
    private String prenom;

    @ManyToMany(mappedBy = "habitants")
    private List<Ville> lstVille = new ArrayList<Ville>();

    public Habitant() {
    }

    public Habitant(Integer id, String nom, String prenom, List<Ville> lstVille) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.lstVille = lstVille;
    }

    @Override
    public String toString() {
        return "Habitant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", lstVille=" + lstVille +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Ville> getLstVille() {
        return lstVille;
    }

    public void setLstVille(List<Ville> lstVille) {
        this.lstVille = lstVille;
    }
}
