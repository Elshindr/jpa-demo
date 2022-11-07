package fr.diginamic.recensement.connexion;
import fr.diginamic.recensement.entites.*;
import fr.diginamic.recensement.entites.Categorie;
import fr.diginamic.recensement.entites.Habitant;
import fr.diginamic.recensement.entites.Region;
import fr.diginamic.recensement.entites.Ville;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * The type Insertion ville jpa.
 */
public class InsertionVilleJpa {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("recensement");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        tr.begin();
        // CREATION REGION
        Region region = new Region();
        region.setNom("Bretagne");
        region.setDateCreation(new Date());
        em.persist(region);

        // CREATION VILLE 1
        Ville villeBrest = new Ville();
        villeBrest.setNom("Brest");
        villeBrest.setCp(29000);

        Date dateenrgB = Calendar.getInstance().getTime();
        villeBrest.setDateEnreg(dateenrgB);
        villeBrest.setCategorie(Categorie.MOYEN);
        villeBrest.setRegion(region);
        em.persist(villeBrest);


        // CREATION VILLE 2
        Ville villeRennes = new Ville();
        villeRennes.setNom("Rennes");
        villeRennes.setCp(75000);
        villeRennes.setDateEnreg(Calendar.getInstance().getTime());
        villeRennes.setCategorie(Categorie.GRAND);
        villeRennes.setRegion(region);
        em.persist(villeRennes);


        // CREATION HABITANT
        Habitant hab = new Habitant();
        hab.setPrenom("Jean");
        hab.setNom("Massiet");
        em.persist(hab);
        villeBrest.getHabitants().add(hab);
        hab.getLstVille().add(villeBrest);


        // CREATION HABITANT
        Habitant hab2 = new Habitant();
        hab2.setPrenom("Aline");
        hab2.setNom("Devign");
        em.persist(hab2);
        villeBrest.getHabitants().add(hab2);
        hab2.getLstVille().add(villeBrest);

        villeRennes.getHabitants().add(hab2);
        hab2.getLstVille().add(villeRennes);

        tr.commit();
    }
}
