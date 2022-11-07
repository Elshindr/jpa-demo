package fr.diginamic.banque.entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Compte")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", unique = true, nullable = false)
    private Integer id;

    @Column(name="NUMERO", nullable = false)
    private String numero;

    @Column(name="SOLDE", nullable = false)
    private double solde;

    @ManyToMany(mappedBy = "lstCompte")
    @Column(name="CLIENT")
    private List<Clients> lstBeneficiaire = new ArrayList<>();

    @OneToMany(mappedBy = "compte")
    @Column(name="OPERATION")
    private List<Operation> lstOperation = new ArrayList<>();


    public Compte() {
    }

    public Compte(Integer id, String numero, double solde) {
        this.id = id;
        this.numero = numero;
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", solde=" + solde +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public List<Clients> getLstBeneficiaire() {
        return lstBeneficiaire;
    }

    public void setLstBeneficiaire(List<Clients> lstBeneficiaire) {
        this.lstBeneficiaire = lstBeneficiaire;
    }

    public List<Operation> getLstOperation() {
        return lstOperation;
    }

    public void setLstOperation(List<Operation> lstOperation) {
        this.lstOperation = lstOperation;
    }
}
