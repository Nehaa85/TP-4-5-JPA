package fr.sdv.b3dev2224.entites;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private double montant;
    private String motif;

    @ManyToOne
    private Compte compte;
}
