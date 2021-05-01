import {NgModule} from '@angular/core';
import {Route, RouterModule} from '@angular/router';
import {SimulationComponent} from './simulation/simulation.component';
import {DataResolveService} from './data-resolve.service';
import {NewSimulationComponent} from './new-simulation/new-simulation.component';
import {UpdateSimulationComponent} from './update-simulation/update-simulation.component';

const DATA_ROUTES: Route[] = [
  {
    path: 'simulations/:id',
    component: SimulationComponent,
    resolve: {dataSimulation: DataResolveService}
  },
  {
    path: 'new-simulation',
    component: NewSimulationComponent
  },
  {
    path: 'simulations/update/:id',
    component: UpdateSimulationComponent,
    resolve: {dataSimulation: DataResolveService}
  }
];

@NgModule({
  imports: [RouterModule.forChild(DATA_ROUTES)],
  exports: [ RouterModule]
})

export class DataRoutingModule { }
