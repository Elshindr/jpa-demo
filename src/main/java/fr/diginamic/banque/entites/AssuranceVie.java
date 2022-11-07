package fr.diginamic.banque.entites;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="AssuranceVie")
public class AssuranceVie extends Compte{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name="DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Column(name="TAUX")
    private double taux;

    public AssuranceVie() {
    }

    public AssuranceVie(Integer id, String numero, double solde, Integer id1, Date dateFin, double taux) {
        super(id, numero, solde);
        this.id = id1;
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
