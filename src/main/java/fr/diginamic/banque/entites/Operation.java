package fr.diginamic.banque.entites;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Operation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", unique = true, nullable = false)
    private Integer id;

    @Column(name="DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name="MONTANT", nullable = false)
    private double montant;

    @Column(name="MOTIF", nullable = false)
    private String motif;

    @ManyToOne
    @JoinColumn(name="ID_CPT")
    private Compte compte;

    public Operation() {
    }

    public Operation(Integer id, Date numero, double montant, String motif) {
        this.id = id;
        this.date = numero;
        this.montant = montant;
        this.motif = motif;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", date=" + date +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
