package fr.diginamic.biblio.entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Livre.
 */
@Entity
@Table(name="livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="TITRE")
    private String titre;

    @Column(name="AUTEUR")
    private String auteur;

    @ManyToMany(mappedBy = "lstLivre")
    private List<Emprunt> lstEmprunt = new ArrayList<>();

    /**
     * Instantiates a new Livre.
     */
    public Livre() {
    }

    /**
     * Instantiates a new Livre.
     *
     * @param id     the id
     * @param titre  the titre
     * @param auteur the auteur
     */
    public Livre(Integer id, String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets titre.
     *
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Sets titre.
     *
     * @param titre the titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Gets auteur.
     *
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Sets auteur.
     *
     * @param auteur the auteur
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     * Gets lst emprunt.
     *
     * @return the lst emprunt
     */
    public List<Emprunt> getLstEmprunt() {
        return lstEmprunt;
    }

    /**
     * Sets lst emprunt.
     *
     * @param lstEmprunt the lst emprunt
     */
    public void setLstEmprunt(List<Emprunt> lstEmprunt) {
        this.lstEmprunt = lstEmprunt;
    }
}
