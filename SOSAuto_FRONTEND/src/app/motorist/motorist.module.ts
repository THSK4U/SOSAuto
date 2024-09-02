import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MotoristRoutingModule } from './motorist-routing.module';
import { MotoristComponent } from './motorist.component';


@NgModule({
  declarations: [
    MotoristComponent
  ],
  imports: [
    CommonModule,
    MotoristRoutingModule
  ]
})
export class MotoristModule { }
