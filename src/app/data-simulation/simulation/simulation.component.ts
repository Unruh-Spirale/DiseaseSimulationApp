import { Component, OnInit } from '@angular/core';
import {DataSimulation} from '../model/data-simulation';
import {DataSimulationService} from '../data-simulation.service';
import {ActivatedRoute} from '@angular/router';
import {CalcSimulation} from '../model/calc-simulation';

import * as Highcharts from 'highcharts';

@Component({
  selector: 'app-simulation',
  templateUrl: './simulation.component.html',
  styleUrls: ['./simulation.component.css']
})
export class SimulationComponent implements OnInit {

  dataSimulation: DataSimulation;
  calcSimulation: CalcSimulation[];
  totalDeaths: number;

  infected: number[];
  susceptibles: number[];
  deaths: number[];
  recoveries: number[];

  constructor(
    private dataService: DataSimulationService,
    private route: ActivatedRoute
  ) { }

  Highcharts: typeof Highcharts = Highcharts;
  chartOptions: Highcharts.Options = {
    chart: {
      type: 'spline'
    },
    title: {
      text: 'Disease Simulation'
    },
    xAxis: {
      title: {
        text: 'days of simulation'
      },
      tickInterval: 1
    },
    yAxis: {
      title: {
        text: 'inhabitants'
      }
    },
    series: [ ]
  };

  ngOnInit(): void {
    this.loadData();
    this.loadDataToCharts();
  }

  loadData(): void{
    this.dataSimulation = this.route.snapshot.data['dataSimulation'];
    this.calcSimulation = this.dataSimulation.calcs;
    this.infected = this.calcSimulation.map((x) => x.infectedPeople);
    this.susceptibles = this.calcSimulation.map((x) => x.susceptiblePeople);
    this.deaths = this.calcSimulation.map((x) => x.deaths);
    this.recoveries = this.calcSimulation.map((x) => x.recoveries);
    this.countTotalDeaths();
  }

  loadDataToCharts(): void{
    this.chartOptions.series = [
      {
        name: 'infected',
        data: this.infected,
        type: 'line'
      },
      {
        name: 'susceptible people',
        data: this.susceptibles,
        type: 'line'
      },
      {
        name: 'deaths',
        data: this.deaths,
        type: 'line'
      },
      {
        name: 'recoveries',
        data: this.recoveries,
        type: 'line'
      }
    ];
  }

  countTotalDeaths(): void{
    this.totalDeaths = this.calcSimulation
      .map((x) => x.deaths)
      .reduce((prev, next) => {
        return prev + next;
    });
  }

}
