package fr.diginamic.banque.entites;

import javax.persistence.*;


@Entity
@Table(name = "Virement")
public class Virement extends Operation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name="BENEFICIAIRE")
    private String beneficiaire;

    public Virement() {
    }

    public Virement(Integer id, String beneficiaire) {
        this.id = id;
        this.beneficiaire = beneficiaire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
