import { Component, OnInit } from '@angular/core';
import {DataSimulation} from '../model/data-simulation';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DataSimulationService} from '../data-simulation.service';

@Component({
  selector: 'app-update-simulation',
  templateUrl: './update-simulation.component.html',
  styleUrls: ['./update-simulation.component.css']
})
export class UpdateSimulationComponent implements OnInit {

  dataSimulation: DataSimulation;
  simulationForm: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private dataService: DataSimulationService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadData();
    this.simulationForm = this.buildSimulationForm();
  }

  loadData(): void{
    this.dataSimulation = this.route.snapshot.data['dataSimulation'];
  }

  buildSimulationForm(): FormGroup{
    return this.formBuilder.group({
      nameSimulation: [this.dataSimulation.nameSimulation, Validators.required],
      population: [this.dataSimulation.population, [Validators.required]],
      initialInfected: [this.dataSimulation.initialInfected, Validators.required],
      diseaseFactor: [this.dataSimulation.diseaseFactor, Validators.required],
      mortalityFactor: [this.dataSimulation.mortalityFactor, [Validators.required, Validators.min(0), Validators.max(1)]],
      daysToRecovery: [this.dataSimulation.daysToRecovery, Validators.required],
      daysToDeath: [this.dataSimulation.daysToDeath, Validators.required],
      daysOfSimulation: [this.dataSimulation.daysOfSimulation, Validators.required],
    });
  }

  updateSimulation(): void {
    this.dataService.updateSimulation(this.dataSimulation.id, this.simulationForm.value).subscribe( () => {
      this.router.navigate(['/simulations', this.dataSimulation.id]);
    });
  }

}
