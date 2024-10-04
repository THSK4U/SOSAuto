import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';

import {DashboardComponent} from "./dashboard/dashboard.component";
import {GesMecaniciensComponent} from "./usersboard/ges-mecaniciens/ges-mecaniciens.component";
import {GesMotoristComponent} from "./usersboard/ges-motorist/ges-motorist.component";

const routes: Routes = [
  {
    path: '', component: AdminComponent,
    children: [
      { path: '', component: DashboardComponent},
      { path: 'mecanicien', component: GesMecaniciensComponent },
      { path: 'automobiliste', component: GesMotoristComponent},
    ]
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
