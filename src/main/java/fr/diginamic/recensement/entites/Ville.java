package fr.diginamic.recensement.entites;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Ville.
 */
@Entity
@Table(name="villes")
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="NOM", length=25, nullable = false)
    private String nom;

    @Column(name="CODE_POSTAL", nullable = false)
    private Integer cp;

    @Temporal(value = TemporalType.DATE)
    @Column(name="DATE_CREATION", nullable = false)
    private Date dateEnreg;

    @Column(name="CATEGORIE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "ID_REGION", nullable = false)
    private Region region;

    @ManyToMany
    @JoinTable(name = "LIEN_VILLE_HABITANTS",
        joinColumns=@JoinColumn(name="ID_VILLE", referencedColumnName = "ID") ,
        inverseJoinColumns = @JoinColumn(name="ID_HABITANT", referencedColumnName = "ID"))
    private List<Habitant> habitants = new ArrayList<Habitant>();


    /**
     * Instantiates a new Ville.
     */
    public Ville() {
    }


    /**
     * Instantiates a new Ville.
     *
     * @param id        the id
     * @param nom       the nom
     * @param cp        the cp
     * @param dateEnreg the date enreg
     * @param categorie the categorie
     * @param region    the region
     */
    public Ville(Integer id, String nom, Integer cp, Date dateEnreg, Categorie categorie, Region region) {
        this.id = id;
        this.nom = nom;
        this.cp = cp;
        this.dateEnreg = dateEnreg;
        this.categorie = categorie;
        this.region = region;
    }

    /**
     * Gets cp.
     *
     * @return the cp
     */
    public Integer getCp() {
        return cp;
    }

    /**
     * Sets cp.
     *
     * @param cp the cp
     */
    public void setCp(Integer cp) {
        this.cp = cp;
    }

    /**
     * Gets categorie.
     *
     * @return the categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Sets categorie.
     *
     * @param categorie the categorie
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
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
     * Sets date enreg.
     *
     * @param dateEnreg the date enreg
     */
    public void setDateEnreg(Date dateEnreg) {
        this.dateEnreg = dateEnreg;
    }

    /**
     * Gets date enreg.
     *
     * @return the date enreg
     */
    public Date getDateEnreg() {
        return dateEnreg;
    }

    /**
     * Gets region.
     *
     * @return the region
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Sets region.
     *
     * @param region the region
     */
    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Habitant> getHabitants() {
        return habitants;
    }

    public void setHabitants(List<Habitant> habitants) {
        this.habitants = habitants;
    }
}
