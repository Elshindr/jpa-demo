package fr.diginamic.recensement.entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Region.
 */
@Entity
@Table(name="regions")
public class Region {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NOM", length=25, nullable = false)
    private String nom;

    @Temporal(value = TemporalType.DATE)
    @Column(name="DATE_CREATION", nullable = true, unique = true)
    private Date dateCreation;

    @OneToMany(mappedBy = "region")
    private List<Ville> villes = new ArrayList<Ville>();

    /**
     * Instantiates a new Region.
     */
    public Region() {
    }

    /**
     * Instantiates a new Region.
     *
     * @param id           the id
     * @param nom          the nom
     * @param dateCreation the date creation
     * @param villes       the villes
     */
    public Region(Integer id, String nom, Date dateCreation, List<Ville> villes) {
        this.id = id;
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.villes = villes;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
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
     * Gets date creation.
     *
     * @return the date creation
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * Sets date creation.
     *
     * @param dateCreation the date creation
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Gets villes.
     *
     * @return the villes
     */
    public List<Ville> getVilles() {
        return villes;
    }

    /**
     * Sets villes.
     *
     * @param villes the villes
     */
    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }
}
