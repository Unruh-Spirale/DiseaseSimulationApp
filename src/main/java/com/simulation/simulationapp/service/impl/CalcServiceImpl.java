package com.simulation.simulationapp.service.impl;

import com.simulation.simulationapp.model.Calc;
import com.simulation.simulationapp.model.Simulation;
import com.simulation.simulationapp.service.CalcService;
import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {

    @Override
    public void calcSimulation(Simulation simulation) {
        double[] susceptible = new double[simulation.getDaysOfSimulation()];
        double[] infected = new double[simulation.getDaysOfSimulation()];
        double[]recovery = new double[simulation.getDaysOfSimulation()];
        double[] deaths = new double[simulation.getDaysOfSimulation()];
        double[] newCases = new double[simulation.getDaysOfSimulation()];

        susceptible[0] = simulation.getPopulation()- simulation.getInitialInfected();
        infected[0] = simulation.getInitialInfected();
        newCases[0] = simulation.getInitialInfected();

        int peak = 0;

        int population = simulation.getPopulation();
        double DFactor = simulation.getDiseaseFactor();
        double MFactor = simulation.getMortalityFactor();
        // -1 because loop start count from 0
        int RDays = simulation.getDaysToRecovery() - 1;
        int DDays = simulation.getDaysToDeath() - 1;

        for(int t =1; t< simulation.getDaysOfSimulation(); t++){

            newCases[t] = ((DFactor*newCases[t-1]*population)/population);
            recovery[t] = t >= RDays ? (newCases[t- RDays]-(int)(newCases[t-RDays]*MFactor)) : 0;
            deaths[t] = t >=  DDays ? (int)(newCases[t-DDays]*MFactor) : 0;
            infected[t] = infected[t-1] + newCases[t] - recovery[t] - deaths[t];
            susceptible[t] = susceptible[t-1] - newCases[t];

            peak++;

            if(susceptible[t] <=0 ){
                susceptible[t] = 0;
                newCases[t] = susceptible[t-1];
                infected[t] =infected[t-1] + newCases[t] - recovery[t] - deaths[t];

                peak = t+1;
                break;
            }
        }
        if (peak >= simulation.getDaysToRecovery()){
            for (int t = peak; t < simulation.getDaysOfSimulation(); t++){
                newCases[t] = 0;
                recovery[t] =newCases[t-RDays] - (int)(newCases[t-RDays]*MFactor);
                deaths[t] = (int)(newCases[t - DDays]*MFactor);
                infected[t] = infected[t-1] - recovery[t] - deaths[t];
                if(infected[t] <= 0 ){
                    infected[t] = 0;
                }
            }
        }

        for (int i =0; i < simulation.getDaysOfSimulation(); i++){
            Calc calc = new Calc();
            calc.setSusceptiblePeople((int)susceptible[i]);
            calc.setInfectedPeople((int)infected[i]);
            calc.setRecoveries((int)recovery[i]);
            calc.setDeaths((int)deaths[i]);

            simulation.getCalcs().add(calc);
        }

    }
}
