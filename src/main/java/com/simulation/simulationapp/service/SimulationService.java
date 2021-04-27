package com.simulation.simulationapp.service;

import com.simulation.simulationapp.model.Simulation;

import java.util.List;
import java.util.Optional;

public interface SimulationService {

    List findAllSimulations();
    Optional<Simulation> findSimulationById(long id);
    void addSimulation(Simulation simulation);
    void deleteSimulation(long id);
    void updateSimulation(long id, Simulation updateSimulation);
}
