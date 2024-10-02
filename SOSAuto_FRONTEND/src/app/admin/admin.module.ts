import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { GesMecaniciensComponent } from './usersboard/ges-mecaniciens/ges-mecaniciens.component';
import { GesMotoristComponent } from './usersboard/ges-motorist/ges-motorist.component';


@NgModule({
  declarations: [
    AdminComponent,
    DashboardComponent,
    GesMecaniciensComponent,
    GesMotoristComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
