package com.simulation.simulationapp.model;

import javax.persistence.*;

@Entity
public class Calc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calc")
    private Long idCalc;
    private double infectedPeople;
    private double susceptiblePeople;
    private double deaths;
    private double recoveries;

    public Calc() {
    }

    public Calc(double infectedPeople, double susceptiblePeople, double deaths, double recoveries) {
        this.infectedPeople = infectedPeople;
        this.susceptiblePeople = susceptiblePeople;
        this.deaths = deaths;
        this.recoveries = recoveries;
    }

    public Long getIdCalc() {
        return idCalc;
    }

    public void setIdCalc(Long idCalc) {
        this.idCalc = idCalc;
    }

    public double getInfectedPeople() {
        return infectedPeople;
    }

    public void setInfectedPeople(double infectedPeople) {
        this.infectedPeople = infectedPeople;
    }

    public double getSusceptiblePeople() {
        return susceptiblePeople;
    }

    public void setSusceptiblePeople(double susceptiblePeople) {
        this.susceptiblePeople = susceptiblePeople;
    }

    public double getDeaths() {
        return deaths;
    }

    public void setDeaths(double deaths) {
        this.deaths = deaths;
    }

    public double getRecoveries() {
        return recoveries;
    }

    public void setRecoveries(double recoveries) {
        this.recoveries = recoveries;
    }
}
