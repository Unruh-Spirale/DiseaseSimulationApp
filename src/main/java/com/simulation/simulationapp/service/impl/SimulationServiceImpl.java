package com.simulation.simulationapp.service.impl;

import com.simulation.simulationapp.model.Calc;
import com.simulation.simulationapp.model.Simulation;
import com.simulation.simulationapp.repository.CalcRepository;
import com.simulation.simulationapp.repository.SimulationRepository;
import com.simulation.simulationapp.service.CalcService;
import com.simulation.simulationapp.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SimulationServiceImpl implements SimulationService {

    private SimulationRepository simulationRepository;
    private CalcRepository calcRepository;
    private CalcService calcService;

    @Autowired
    public SimulationServiceImpl(SimulationRepository simulationRepository,CalcRepository calcRepository, CalcService calcService) {
        this.simulationRepository = simulationRepository;
        this.calcRepository = calcRepository;
        this.calcService = calcService;
    }

    @Override
    public List findAllSimulations() {
        return simulationRepository.findAll();
    }

    @Override
    public Optional<Simulation> findSimulationById(long id) {
        return simulationRepository.findById(id);
    }

    @Override
    public void addSimulation(Simulation simulation) {
        calcService.calcSimulation(simulation);
        simulationRepository.save(simulation);
    }

    @Override
    public void deleteSimulation(long id) {
        simulationRepository.deleteById(id);
    }

    @Override
    public void updateSimulation(long id, Simulation updateSimulation) {
        Optional<Simulation> optional = simulationRepository.findById(id);
        Simulation simulation = optional.get();

        List<Long> collect = simulation.getCalcs().stream().map(calc -> calc.getIdCalc()).collect(Collectors.toList());

        simulation.getCalcs().clear();

        for(Long idCalc: collect){
            calcRepository.deleteById(idCalc);
        }

        simulation.setNameSimulation(updateSimulation.getNameSimulation());
        simulation.setPopulation(updateSimulation.getPopulation());
        simulation.setInitialInfected(updateSimulation.getInitialInfected());
        simulation.setDiseaseFactor(updateSimulation.getDiseaseFactor());
        simulation.setMortalityFactor(updateSimulation.getMortalityFactor());
        simulation.setDaysToRecovery(updateSimulation.getDaysToRecovery());
        simulation.setDaysToDeath(updateSimulation.getDaysToDeath());
        simulation.setDaysOfSimulation(updateSimulation.getDaysOfSimulation());

        calcService.calcSimulation(simulation);



        simulationRepository.save(simulation);

    }
}
