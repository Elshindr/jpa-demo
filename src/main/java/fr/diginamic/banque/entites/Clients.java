package fr.diginamic.banque.entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The type Clients.
 */
@Entity
@Table(name="Clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id ;

    @Column(name="NOM")
    private String nom;

    @Column(name="PRENOM")
    private String prenom;

    @Column(name="DATE_NAISSANCE")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Embedded
    @Column(name="ADRESSE")
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "ID_BANQUE", nullable = false)
    private Banque banque;

    @ManyToMany
    @JoinTable(name="LIEN_CLIENT_COMPTE",
            joinColumns = @JoinColumn(name="ID_CLI", referencedColumnName ="ID"),
            inverseJoinColumns = @JoinColumn(name="ID_CPT", referencedColumnName = "ID")
    )
    private List<Compte> lstCompte = new ArrayList<>();

    /**
     * Instantiates a new Clients.
     */
    public Clients() {
    }

    public Clients(Integer id, String nom, String prenom, Date dateNaissance, Adresse adresse, Banque banque) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.banque = banque;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", adresse=" + adresse +
                ", banque=" + banque +
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

   public Adresse getAdresse() {return adresse;}

    public void setAdresse(Adresse adresse) {this.adresse = adresse;}

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public List<Compte> getLstCompte() {
        return lstCompte;
    }

    public void setLstCompte(List<Compte> lstCompte) {
        this.lstCompte = lstCompte;
    }
}

