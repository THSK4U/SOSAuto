import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MotoristComponent } from './motorist.component';
import {HomeComponent} from "../motorist/home/home.component";
import {ProfileComponent} from "../mechanic/profile/profile.component";
import {HistoriqueComponent} from "./historique/historique.component";

const routes: Routes = [
  {
    path: '', component: MotoristComponent,
    children: [
      { path: '', component: HomeComponent },
      { path: 'profile', component: ProfileComponent },
      {path: 'historique', component: HistoriqueComponent},
    ]
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  declarations: [
  ],
  exports: [RouterModule]
})
export class MotoristRoutingModule { }
