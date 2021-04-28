package com.simulation.simulationapp;

import com.simulation.simulationapp.model.Simulation;
import com.simulation.simulationapp.service.SimulationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SimulationappApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SimulationappApplication.class, args);

        Simulation sim1 = new Simulation("First Simulation", 20000,1,2,0.1,4,2,20);

        SimulationService simulationService = ctx.getBean(SimulationService.class);

        simulationService.addSimulation(sim1);

    }

}
