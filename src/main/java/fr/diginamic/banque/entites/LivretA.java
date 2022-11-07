package fr.diginamic.banque.entites;

import javax.persistence.*;

@Entity
@Table(name="LivretA")
public class LivretA extends Compte{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name="TAUX")
    private double taux;

    public LivretA() {
    }

    public LivretA(Integer id, String numero, double solde, Integer id1, double taux) {
        super(id, numero, solde);
        this.id = id1;
        this.taux = taux;
    }


    @Override
    public String toString() {
        return "LivretA{" +
                "id=" + id +
                ", taux=" + taux +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
