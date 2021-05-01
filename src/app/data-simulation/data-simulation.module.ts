import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataSimulationListComponent } from './data-simulation-list/data-simulation-list.component';
import {SharedModule} from '../shared/shared.module';
import {DataRoutingModule} from './data-routing.module';
import { SimulationComponent } from './simulation/simulation.component';
import {DataResolveService} from './data-resolve.service';
import {HighchartsChartModule} from 'highcharts-angular';
import { NewSimulationComponent } from './new-simulation/new-simulation.component';
import { UpdateSimulationComponent } from './update-simulation/update-simulation.component';
import {ReactiveFormsModule} from '@angular/forms';




@NgModule({
  declarations: [
    DataSimulationListComponent,
    SimulationComponent,
    NewSimulationComponent,
    UpdateSimulationComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    DataRoutingModule,
    HighchartsChartModule,
    ReactiveFormsModule
  ],
  providers: [DataResolveService]
})
export class DataSimulationModule { }
