import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import {MapComponent} from "./mechanic/map/map.component";
import {SigninComponent} from "./authentication/signin/signin.component";
import {SignupComponent} from "./authentication/signup/signup.component";
import {HomeComponent} from "./home/home.component";
import {
  ListParticipationComponent
} from "./motorist/participation-demande/list-participation/list-participation.component";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent},
  { path: 'automobiliste', loadChildren: () => import('./motorist/motorist.module').then(m => m.MotoristModule) },
  { path: 'mecanicien', loadChildren: () => import('./mechanic/mechanic.module').then(m => m.MechanicModule) },
  { path: 'admin', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },
  { path: 'login', component: SigninComponent},
  { path: 'register', component: SignupComponent},
  {path: 'MAP', component: MapComponent},
  {path: 'part', component: ListParticipationComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
