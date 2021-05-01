import { Component, OnInit } from '@angular/core';
import {DataSimulation} from '../model/data-simulation';
import {DataSimulationService} from '../data-simulation.service';

import * as Highcharts from 'highcharts';
import {Router} from '@angular/router';

@Component({
  selector: 'app-data-simulation-list',
  templateUrl: './data-simulation-list.component.html',
  styleUrls: ['./data-simulation-list.component.css']
})
export class DataSimulationListComponent implements OnInit {

  dataSimulation: DataSimulation[];

  constructor(
    private dataService: DataSimulationService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getAllSimulation();
  }

  getAllSimulation(): void{
    this.dataService.getAllSimulation().subscribe((data) => {
      this.dataSimulation = data;
    });
  }

  deleteSimulation(id: number, event): void{
    event.stopPropagation();
    this.dataService.deleteSimulation(id).subscribe( () => {
      return this.getAllSimulation();
    });
  }

}
