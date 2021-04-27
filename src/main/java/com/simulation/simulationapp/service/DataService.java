package com.simulation.simulationapp.service;

import com.simulation.simulationapp.model.Data;

import java.util.List;
import java.util.Optional;

public interface DataService {

    List findAllSimulations();
    Optional<Data> findSimulationById(long id);
    void addSimulation(Data data);
    void deleteSimulation(long id);
    void updateSimulation(long id, Data updateData);
}
