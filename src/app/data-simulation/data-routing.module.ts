import {NgModule} from '@angular/core';
import {Route, RouterModule} from '@angular/router';
import {SimulationComponent} from './simulation/simulation.component';
import {DataResolveService} from './data-resolve.service';
import {NewSimulationComponent} from './new-simulation/new-simulation.component';
import {UpdateSimulationComponent} from './update-simulation/update-simulation.component';
import {DataSimulationListComponent} from './data-simulation-list/data-simulation-list.component';
import {HistoryComponent} from './history/history.component';

const DATA_ROUTES: Route[] = [
  {
    path: 'simulations',
    component: DataSimulationListComponent
  },
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
  },
  {
    path: 'history',
    component: HistoryComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(DATA_ROUTES)],
  exports: [ RouterModule]
})

export class DataRoutingModule { }
