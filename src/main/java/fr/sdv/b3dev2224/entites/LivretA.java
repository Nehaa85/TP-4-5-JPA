package fr.sdv.b3dev2224.entites;

import jakarta.persistence.Entity;

@Entity
public class LivretA extends Compte {
    private int id;
    private double taux;

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
