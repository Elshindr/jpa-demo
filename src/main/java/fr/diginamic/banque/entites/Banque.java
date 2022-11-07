package fr.diginamic.banque.entites;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Banque")
public class Banque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", unique = true, nullable = false)
    private Integer id;

    @Column(name="NOM", nullable = false)
    private String nom;

    @OneToMany(mappedBy = "banque")
    private List<Clients> lstClients = new ArrayList<>();

    public Banque() {
    }

    public Banque(Integer id, String nom, List<Clients> lstClients) {
        this.id = id;
        this.nom = nom;
        this.lstClients = lstClients;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", lstClients=" + lstClients +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Clients> getLstClients() {
        return lstClients;
    }

    public void setLstClients(List<Clients> lstClients) {
        this.lstClients = lstClients;
    }
}
