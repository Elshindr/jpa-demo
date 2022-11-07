package fr.diginamic.biblio.connexion;

import fr.diginamic.biblio.entites.Client;
import fr.diginamic.biblio.entites.Emprunt;
import fr.diginamic.biblio.entites.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblio");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        tr.begin();
        // LISTER LES LIVRES D'UN EMPRUNT
        Emprunt emprunt = em.find(Emprunt.class, 1);

        if(emprunt != null){
            System.out.println(emprunt);
            for(Livre livre : emprunt.getLstLivre()){
                Livre livre_trouve = em.find(Livre.class, livre.getId());

                System.out.println(livre_trouve);
            }
        }


        // LISTER LES EMPRUNTS D'UN CLIENT
        Client client = em.find(Client.class, 1);

        if(client != null){
            System.out.println(client);
            for (Emprunt emp : client.getLstEmprunt()){
                Emprunt emprunt_trouve = em.find(Emprunt.class, emp.getId());
                System.out.println(emprunt_trouve);
            }
        }

        tr.commit();
    }
}
