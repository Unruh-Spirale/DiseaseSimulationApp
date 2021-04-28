package com.simulation.simulationapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Simulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_data")
    private Long id;
    private String nameSimulation;
    private int population;
    private int initialInfected;
    private double diseaseFactor;
    private double mortalityFactor;
    private int daysToRecovery;
    private int daysToDeath;
    private int daysOfSimulation;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_data")
    private List<Calc> calcs = new ArrayList<>();

    public Simulation() {
    }

    public Simulation(String nameSimulation, int population, int initialInfected, double diseaseFactor, double mortalityFactor, int daysToRecovery, int daysToDeath, int daysOfSimulation) {
        this.nameSimulation = nameSimulation;
        this.population = population;
        this.initialInfected = initialInfected;
        this.diseaseFactor = diseaseFactor;
        this.mortalityFactor = mortalityFactor;
        this.daysToRecovery = daysToRecovery;
        this.daysToDeath = daysToDeath;
        this.daysOfSimulation = daysOfSimulation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSimulation() {
        return nameSimulation;
    }

    public void setNameSimulation(String nameSimulation) {
        this.nameSimulation = nameSimulation;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getInitialInfected() {
        return initialInfected;
    }

    public void setInitialInfected(int initialInfected) {
        this.initialInfected = initialInfected;
    }

    public double getDiseaseFactor() {
        return diseaseFactor;
    }

    public void setDiseaseFactor(double diseaseFactor) {
        this.diseaseFactor = diseaseFactor;
    }

    public double getMortalityFactor() {
        return mortalityFactor;
    }

    public void setMortalityFactor(double mortalityFactor) {
        this.mortalityFactor = mortalityFactor;
    }

    public int getDaysToRecovery() {
        return daysToRecovery;
    }

    public void setDaysToRecovery(int daysToRecovery) {
        this.daysToRecovery = daysToRecovery;
    }

    public int getDaysToDeath() {
        return daysToDeath;
    }

    public void setDaysToDeath(int daysToDeath) {
        this.daysToDeath = daysToDeath;
    }

    public int getDaysOfSimulation() {
        return daysOfSimulation;
    }

    public void setDaysOfSimulation(int daysOfSimulation) {
        this.daysOfSimulation = daysOfSimulation;
    }

    public List<Calc> getCalcs() {
        return calcs;
    }

    public void setCalcs(List<Calc> calcs) {
        this.calcs = calcs;
    }
}
