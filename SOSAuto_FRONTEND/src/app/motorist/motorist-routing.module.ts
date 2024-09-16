import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MotoristComponent } from './motorist.component';

const routes: Routes = [
  {
    path: '', component: MotoristComponent
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  declarations: [
  ],
  exports: [RouterModule]
})
export class MotoristRoutingModule { }
