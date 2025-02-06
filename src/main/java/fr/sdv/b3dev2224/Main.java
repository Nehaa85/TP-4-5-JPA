package fr.sdv.b3dev2224;

import fr.sdv.b3dev2224.entites.Adresse;
import fr.sdv.b3dev2224.entites.Banque;
import fr.sdv.b3dev2224.entites.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banquePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Banque banque = new Banque();
        banque.setNom("Ma Banque");
        em.persist(banque);

        Client client = new Client();
        client.setNom("Ella");
        client.setPrenom("Bienbu");
        client.setDateNaissance(LocalDate.parse("2018-01-20"));
        client.setBanque(banque);
        client.setAdresse(new Adresse("1", "rue de février", "85270", "Saint Hilaire"));
        em.persist(client);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
