import { Component } from '@angular/core';
import {CreatdemandeComponent} from "./creatdemande/creatdemande.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-motorist',
  templateUrl: './motorist.component.html',
  styleUrls: ['./motorist.component.scss']
})
export class MotoristComponent {
  constructor(
    private dialog: MatDialog,
  ) {
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(CreatdemandeComponent, {
      width: '250px',
    });

  }
}
