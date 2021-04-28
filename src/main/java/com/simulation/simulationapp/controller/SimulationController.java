package com.simulation.simulationapp.controller;

import com.simulation.simulationapp.model.Simulation;
import com.simulation.simulationapp.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/simulations")
public class SimulationController {

    private SimulationService simulationService;

    @Autowired
    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping
    public List<Simulation> getAllSimulations(){
        return simulationService.findAllSimulations();
    }

    @GetMapping("/{id}")
    public Optional<Simulation> getSimulation(@PathVariable("id") long idSimulation){
        return simulationService.findSimulationById(idSimulation);
    }

    @PostMapping
    public void addSimulation(@RequestBody Simulation simulation){
        simulationService.addSimulation(simulation);
    }

    @PutMapping("/{id}")
    public void updateSimulation(@PathVariable("id") long idSimulation,@RequestBody Simulation updateSimulation){
        simulationService.updateSimulation(idSimulation,updateSimulation);
    }

    @DeleteMapping("/{id}")
    public void deleteSimulation(@PathVariable("id") long idSimulation){
        simulationService.deleteSimulation(idSimulation);
    }
}
