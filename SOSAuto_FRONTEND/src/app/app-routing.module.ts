import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import {MapComponent} from "./mechanic/map/map.component";
import {SigninComponent} from "./authentication/signin/signin.component";

const routes: Routes = [
  {
    path: '',component: AppComponent,
  },
  { path: 'automobiliste', loadChildren: () => import('./motorist/motorist.module').then(m => m.MotoristModule) },
  { path: 'mecanicien', loadChildren: () => import('./mechanic/mechanic.module').then(m => m.MechanicModule) },
  { path: 'admin', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },
  { path: 'login', component: SigninComponent},
  {path: 'MAP', component: MapComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
