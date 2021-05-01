import {Injectable} from '@angular/core';
import {DataSimulationService} from './data-simulation.service';
import {ActivatedRouteSnapshot, Resolve} from '@angular/router';
import {DataSimulation} from './model/data-simulation';

@Injectable()
export class DataResolveService implements Resolve<DataSimulation>{
  constructor(
    private dataService: DataSimulationService) {
  }

  resolve(route: ActivatedRouteSnapshot) {
    return this.dataService.getSimulation(route.params['id']);
  }
}
