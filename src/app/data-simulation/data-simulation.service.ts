import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DataSimulation} from './model/data-simulation';
import {Injectable} from '@angular/core';

@Injectable()
export class DataSimulationService{

  private apiUrl = 'http://localhost:8080/api/simulations';

  constructor(private httpClient: HttpClient) {
  }

  getAllSimulation(): Observable<DataSimulation[]>{
    return this.httpClient.get<DataSimulation[]>(this.apiUrl);
  }

  getSimulation(id: number): Observable<DataSimulation>{
    return this.httpClient.get<DataSimulation>(this.apiUrl + '/' + id);
  }

  addSimulation(data: DataSimulation): Observable<DataSimulation>{
    return this.httpClient.post<DataSimulation>(this.apiUrl, data);
  }

  updateSimulation(id: number, data: DataSimulation): Observable<DataSimulation>{
    return this.httpClient.put<DataSimulation>(this.apiUrl + '/' + id, data);
  }

  deleteSimulation(id: number): Observable<DataSimulation>{
    return this.httpClient.delete<DataSimulation>(this.apiUrl + '/' + id);
  }
}
