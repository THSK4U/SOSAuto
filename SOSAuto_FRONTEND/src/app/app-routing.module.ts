import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import {MapComponent} from "./mechanic/map/map.component";
import {SigninComponent} from "./authentication/signin/signin.component";

const routes: Routes = [
  {
    path: '',component: AppComponent,
  },
  { path: 'Automobiliste', loadChildren: () => import('./motorist/motorist.module').then(m => m.MotoristModule) },
  { path: 'Mecanicien', loadChildren: () => import('./mechanic/mechanic.module').then(m => m.MechanicModule) },
  { path: 'Admin', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },
  { path: 'Login', component: SigninComponent},
  {path: 'MAP', component: MapComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
