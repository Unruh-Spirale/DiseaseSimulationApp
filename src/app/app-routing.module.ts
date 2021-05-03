import {NgModule} from '@angular/core';
import {Route, RouterModule} from '@angular/router';
import {DataSimulationListComponent} from './data-simulation/data-simulation-list/data-simulation-list.component';
import {DashboardComponent} from './data-simulation/dashboard/dashboard.component';

const APP_ROUTES: Route[] = [
  {
    path: '', pathMatch: 'full', redirectTo: 'dashboard'
  },
  {
    path: 'dashboard', component: DashboardComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(APP_ROUTES)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
