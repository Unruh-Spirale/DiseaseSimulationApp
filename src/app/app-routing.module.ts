import {NgModule} from '@angular/core';
import {Route, RouterModule} from '@angular/router';
import {DataSimulationListComponent} from './data-simulation/data-simulation-list/data-simulation-list.component';

const APP_ROUTES: Route[] = [
  {
    path: '', pathMatch: 'full', redirectTo: 'simulations'
  },
  {
    path: 'simulations', component: DataSimulationListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(APP_ROUTES)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
