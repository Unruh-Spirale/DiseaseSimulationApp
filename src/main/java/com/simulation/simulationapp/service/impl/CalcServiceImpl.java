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
        int RDays = simulation.getDaysToRecovery();
        int DDays = simulation.getDaysToDeath();

        for(int t =1; t< simulation.getDaysOfSimulation(); t++){

            newCases[t] = ((DFactor*newCases[t-1]*population)/population);
            recovery[t] = t > RDays ? (newCases[t- RDays]-(newCases[t-RDays]*MFactor)) : 0;
            deaths[t] = t >  DDays ? (newCases[t-DDays]*MFactor) : 0;
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
                recovery[t] =newCases[t-RDays] - (newCases[t-RDays]*MFactor);
                deaths[t] = newCases[t - DDays]*MFactor;
                infected[t] = infected[t-1] - recovery[t] - deaths[t];
                if(infected[t] < 0 ){
                    infected[t] = 0;
                }
            }
        }
        for (int i =0; i < simulation.getDaysOfSimulation(); i++){
            Calc calc = new Calc();
            calc.setSusceptiblePeople(susceptible[i]);
            calc.setInfectedPeople(infected[i]);
            calc.setRecoveries(recovery[i]);
            calc.setDeaths(deaths[i]);

            simulation.getCalcs().add(calc);
        }

    }
}
