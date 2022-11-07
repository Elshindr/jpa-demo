package fr.diginamic.banque.connexion;

import fr.diginamic.banque.entites.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class connexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banque");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        tr.begin();
        //CREATION BANQUES
        Banque banquePostal = new Banque();
        banquePostal.setNom("La Banque Postale");
        em.persist(banquePostal);

        Banque bnp = new Banque();
        bnp.setNom("Banque National Populaire");
        em.persist(bnp);

        Banque cic = new Banque();
        cic.setNom("Caisse International Castastrophique");
        em.persist(cic);

        // CREATION COMPTE
        LivretA compte_fr = new LivretA();
        compte_fr.setSolde(3123213);
        compte_fr.setNumero("FzeRZEr45_FR");
        compte_fr.setTaux(13);
        em.persist(compte_fr);

        AssuranceVie compte_usa = new AssuranceVie();
        compte_usa.setSolde(999999);
        compte_usa.setNumero("FD-765-dfg_USA");
        compte_usa.setDateFin(new Date());
        compte_usa.setTaux(12);
      em.persist(compte_usa);

        LivretA compte_ru = new LivretA();
        compte_ru.setSolde(3123213);
        compte_ru.setNumero("OPKJ-gbv-3432_RU");
        compte_ru.setTaux(3);
       em.persist(compte_ru);


        // CREATION ADRESSE
        Adresse rennes = new Adresse();
        rennes.setNumero(3);
        rennes.setRue("Allées des longs couteaux");
        rennes.setCp(75000);
        rennes.setVille("Rennes");
        //em.persist(rennes);

        Adresse noumea = new Adresse();
        noumea.setNumero(34);
        noumea.setRue("Boulevard des cocotiers");
        noumea.setCp(98);
        noumea.setVille("Noumea");
        //em.persist(noumea);

        Adresse brest = new Adresse();
        brest.setNumero(12);
        brest.setRue("Rue de Jean Mace");
        brest.setCp(29000);
        brest.setVille("Brest");
        //em.persist(brest);

        // CREATION CLIENT
        Clients pote = new Clients();
        pote.setNom("Hue");
        pote.setPrenom("Jing");
        pote.setDateNaissance(new Date());
        pote.setAdresse(brest);
        pote.setBanque(banquePostal);


        pote.getLstCompte().add(compte_fr);
        pote.getLstCompte().add(compte_ru);
        compte_fr.getLstBeneficiaire().add(pote);
        compte_ru.getLstBeneficiaire().add(pote);
        em.persist(pote);

        Clients client = new Clients();
        client.setNom("Laain");
        client.setPrenom("Marie Michellina");
        client.setDateNaissance(new Date());
        client.setAdresse(rennes);
        client.setBanque(cic);
        em.persist(client);

        client.getLstCompte().add(compte_usa);
        client.getLstCompte().add(compte_ru);
        compte_usa.getLstBeneficiaire().add(client);
        compte_ru.getLstBeneficiaire().add(client);



        Clients clien = new Clients();
        clien.setNom("Hunada");
        clien.setPrenom("Malaado");
        clien.setDateNaissance(new Date());
        clien.setAdresse(noumea);
        clien.setBanque(bnp);
        em.persist(clien);
        clien.getLstCompte().add(compte_usa);
        clien.getLstCompte().add(compte_fr);
        compte_usa.getLstBeneficiaire().add(clien);
        compte_fr.getLstBeneficiaire().add(clien);



        // CREATION OPERATION
        Virement op_mar = new Virement();
        op_mar.setBeneficiaire("benfe3");
        op_mar.setMontant(12312);
        op_mar.setMotif("Mariage");
        op_mar.setDate(new Date());
        em.persist(op_mar);

        Virement op_annif = new Virement();
        op_annif.setBeneficiaire("benfe2");
        op_annif.setMontant(1000000);
        op_annif.setMotif("Anniversaire du Furet");
        op_annif.setDate(new Date());
        op_annif.setCompte(compte_fr);
        em.persist(op_annif);
        compte_fr.getLstOperation().add(op_annif);


        Virement op_noel = new Virement();
        op_noel.setBeneficiaire("benfe1");
        op_noel.setMontant(-1231);
        op_noel.setMotif("Noel");
        op_noel.setDate(new Date());
        op_noel.setCompte(compte_ru);
        em.persist(op_noel);
        compte_ru.getLstOperation().add(op_mar);
        compte_ru.getLstOperation().add(op_annif);
        compte_ru.getLstOperation().add(op_mar);

        tr.commit();
        em.close();
        System.out.println("Succeed");
    }
}
