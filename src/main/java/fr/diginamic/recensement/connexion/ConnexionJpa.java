package fr.diginamic.recensement.connexion;

import fr.diginamic.recensement.entites.Region;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * The type Connexion jpa.
 */
public class ConnexionJpa {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("recensement");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        Region reg = em.find(Region.class,2); // find(object, id)

        if( reg == null){
            transaction.begin();  // DEBUT : Mises à jour, insertions et suppressions
            System.out.println("pas trouvé");
            Region region = new Region();
            //region.setId(1);
            region.setNom("PACA");
            region.setDateCreation(new Date());
            em.persist(region);
            transaction.commit();// FIN : Mises à jour, insertions et suppressions

        }
        else{
            System.out.println("deja présent");
            //System.out.println(region.toString());
        }


    }
}
