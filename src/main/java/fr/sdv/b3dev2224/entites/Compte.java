package fr.sdv.b3dev2224.entites;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private double solde;

    @ManyToMany
    @JoinTable(name = "client_compte",
            joinColumns = @JoinColumn(name = "compte_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> titulaires;

    @OneToMany(mappedBy = "compte")
    private List<Operation> operations;
}
