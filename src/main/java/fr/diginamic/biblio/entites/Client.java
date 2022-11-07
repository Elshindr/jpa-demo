package fr.diginamic.biblio.entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Clients.
 */
@Entity
@Table(name="Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id ;

    @Column(name="NOM")
    private String nom;

    @Column(name="PRENOM")
    private String prenom;

    @OneToMany(mappedBy = "client")
    private List<Emprunt> lstEmprunt = new ArrayList<>();

    /**
     * Instantiates a new Clients.
     */
    public Client() {
    }

    /**
     * Instantiates a new Clients.
     *
     * @param id         the id
     * @param nom        the nom
     * @param prenom     the prenom
     * @param lstEmprunt the lst emprunt
     */
    public Client(Integer id, String nom, String prenom, List<Emprunt> lstEmprunt) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.lstEmprunt = lstEmprunt;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
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
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Gets prenom.
     *
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets prenom.
     *
     * @param prenom the prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
