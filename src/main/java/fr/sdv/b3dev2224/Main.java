package fr.sdv.b3dev2224;

import fr.sdv.b3dev2224.entites.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banquePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
//
//        Banque banque = new Banque();
//        banque.setNom("Ma Banque");
//        em.persist(banque);

        Client client = new Client();
        client.setNom("Encieux");
        client.setPrenom("Cecile");
        client.setDateNaissance(LocalDate.parse("1999-07-20"));
//        client.setBanque(banque);
        client.setAdresse(new Adresse("7", "rue de juillet", "44300", "Carquefou"));
        em.persist(client);

        AssuranceVie assuranceVie = new AssuranceVie();
        assuranceVie.setTaux(2.5);
        assuranceVie.setDateFin(LocalDate.parse("2031-05-20"));

        LivretA livretA = new LivretA();
        livretA.setTaux(3.00);

        Virement virement = new Virement();
        virement.setBeneficiaire("Barbeau");


        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
