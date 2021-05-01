import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import {DataSimulationService} from './data-simulation/data-simulation.service';
import {DataSimulationModule} from './data-simulation/data-simulation.module';
import {DataRoutingModule} from './data-simulation/data-routing.module';
import {CoreModule} from './core/core.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    DataSimulationModule,
    DataRoutingModule,
    CoreModule
  ],
  providers: [ DataSimulationService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
