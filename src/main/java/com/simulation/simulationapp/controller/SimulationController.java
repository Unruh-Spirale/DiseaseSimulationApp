package com.simulation.simulationapp.controller;

import com.simulation.simulationapp.model.Simulation;
import com.simulation.simulationapp.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void addSimulation(@RequestBody Simulation simulation){
        simulationService.addSimulation(simulation);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateSimulation(@PathVariable("id") long idSimulation,@RequestBody Simulation updateSimulation){
        simulationService.updateSimulation(idSimulation,updateSimulation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSimulation(@PathVariable("id") long idSimulation){
        boolean anyElementRemoved = simulationService.findSimulationById(idSimulation).isPresent();

        if (anyElementRemoved) {
            simulationService.deleteSimulation(idSimulation);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
