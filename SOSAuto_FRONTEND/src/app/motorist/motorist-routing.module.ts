import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MotoristComponent } from './motorist.component';
import {HomeComponent} from "../motorist/home/home.component";
import {ProfileComponent} from "../mechanic/profile/profile.component";
import {HistoriqueComponent} from "./historique/historique.component";
import {ParticipationDemandeComponent} from "./participation-demande/participation-demande.component";
import {ListParticipationComponent} from "./participation-demande/list-participation/list-participation.component";
import {TrackPageComponent} from "./track-page/track-page.component";

const routes: Routes = [
  {
    path: '', component: MotoristComponent,
    children: [
      { path: '', component: HomeComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'historique', component: HistoriqueComponent},
      { path: 'participation/:id', component: ParticipationDemandeComponent},
      { path: 'tracknumber/:id', component: TrackPageComponent }
    ]
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MotoristRoutingModule { }
