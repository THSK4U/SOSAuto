import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import {MapComponent} from "./mechanic/map/map.component";
import {SigninComponent} from "./authentication/signin/signin.component";
import {SignupComponent} from "./authentication/signup/signup.component";
import {HomeComponent} from "./home/home.component";
import {authGuard} from "./services/token/guard/auth.guard";
import {Role} from "./services/models/Role";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent},
  { path: 'automobiliste', loadChildren: () => import('./motorist/motorist.module').then(m => m.MotoristModule) , canActivate: [authGuard], data: { expectedRole: Role.AUTO }},
  { path: 'mecanicien', loadChildren: () => import('./mechanic/mechanic.module').then(m => m.MechanicModule) , canActivate: [authGuard], data: { expectedRole: Role.MECA }},
  { path: 'admin', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) , canActivate: [authGuard], data: { expectedRole: Role.ADMIN }},
  { path: 'login', component: SigninComponent},
  { path: 'register', component: SignupComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
