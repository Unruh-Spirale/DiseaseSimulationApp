import {CalcSimulation} from './calc-simulation';

export interface DataSimulation{
  id: number;
  nameSimulation: string;
  population: number;
  initialInfected: number;
  diseaseFactor: number;
  mortalityFactor: number;
  daysToRecovery: number;
  daysToDeath: number;
  daysOfSimulation: number;
  calcs: CalcSimulation[];
}
