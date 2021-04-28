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
        Simulation sim2 = new Simulation("Second Simulation", 5000,1,1.5,0.2,10,5,25);
        Simulation sim3 = new Simulation("Third Simulation", 20000,5,3,0.15,4,2,100);

        SimulationService simulationService = ctx.getBean(SimulationService.class);

        simulationService.addSimulation(sim1);
        simulationService.addSimulation(sim2);
        simulationService.addSimulation(sim3);

    }

}
