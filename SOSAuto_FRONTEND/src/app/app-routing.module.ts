import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import {MapComponent} from "./mechanic/map/map.component";

const routes: Routes = [
  {
    path: '',component: AppComponent,
  },
  { path: 'Automobiliste', loadChildren: () => import('./motorist/motorist.module').then(m => m.MotoristModule) },
  { path: 'Mecanicien', loadChildren: () => import('./mechanic/mechanic.module').then(m => m.MechanicModule) },
  { path: 'Admin', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },
  {path: 'MAP', component: MapComponent},
  { path: '**', component: AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
