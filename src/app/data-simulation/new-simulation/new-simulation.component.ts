import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CalcSimulation} from '../model/calc-simulation';
import {DataSimulationService} from '../data-simulation.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-new-simulation',
  templateUrl: './new-simulation.component.html',
  styleUrls: ['./new-simulation.component.css']
})
export class NewSimulationComponent implements OnInit {

  simulationForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private dataService: DataSimulationService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.simulationForm = this.buildSimulationForm();
  }

  buildSimulationForm(): FormGroup{
    return this.formBuilder.group({
      nameSimulation: ['', Validators.required],
      population: ['', [Validators.required]],
      initialInfected: ['', Validators.required],
      diseaseFactor: ['', Validators.required],
      mortalityFactor: ['', [Validators.required, Validators.min(0), Validators.max(1)]],
      daysToRecovery: ['', Validators.required],
      daysToDeath: ['', Validators.required],
      daysOfSimulation: ['', Validators.required],
    });
  }

  addSimulation(): void{
    this.dataService.addSimulation(this.simulationForm.value).subscribe( () => {
      this.router.navigate(['/simulations']);
    })
  }

}
