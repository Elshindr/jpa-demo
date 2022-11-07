package fr.diginamic.biblio.entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Emprunt.
 */
@Entity
@Table(name="Emprunt")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="DATE_DEBUT")
    @Temporal(TemporalType.DATE)
    private Date date_debut;

    @Column(name="DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date date_fin;

    @Column(name="DELAI")
    private Integer delai;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", nullable = false)
    private Client client;

    @ManyToMany
    @JoinTable(name="compo",
        joinColumns = @JoinColumn(name="ID_EMP", referencedColumnName ="ID"),
        inverseJoinColumns = @JoinColumn(name="ID_LIV", referencedColumnName = "ID")
    )
    private List<Livre> lstLivre = new ArrayList<Livre>();

    /**
     * Instantiates a new Emprunt.
     */
    public Emprunt() {

    }

    /**
     * Instantiates a new Emprunt.
     *
     * @param id         the id
     * @param date_debut the date debut
     * @param date_fin   the date fin
     * @param delai      the delai
     * @param client     the client
     * @param lstLivre   the lst livre
     */
    public Emprunt(Integer id, Date date_debut, Date date_fin, Integer delai, Client client, List<Livre> lstLivre) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.delai = delai;
        this.client = client;
        this.lstLivre = lstLivre;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", delai=" + delai +
                ", client=" + client +
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
     * Gets date debut.
     *
     * @return the date debut
     */
    public Date getDate_debut() {
        return date_debut;
    }

    /**
     * Sets date debut.
     *
     * @param date_debut the date debut
     */
    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    /**
     * Gets date fin.
     *
     * @return the date fin
     */
    public Date getDate_fin() {
        return date_fin;
    }

    /**
     * Sets date fin.
     *
     * @param date_fin the date fin
     */
    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    /**
     * Gets delai.
     *
     * @return the delai
     */
    public Integer getDelai() {
        return delai;
    }

    /**
     * Sets delai.
     *
     * @param delai the delai
     */
    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    /**
     * Gets client.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets client.
     *
     * @param client the client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Gets lst livre.
     *
     * @return the lst livre
     */
    public List<Livre> getLstLivre() {
        return lstLivre;
    }

    /**
     * Sets lst livre.
     *
     * @param lstLivre the lst livre
     */
    public void setLstLivre(List<Livre> lstLivre) {
        this.lstLivre = lstLivre;
    }
}
