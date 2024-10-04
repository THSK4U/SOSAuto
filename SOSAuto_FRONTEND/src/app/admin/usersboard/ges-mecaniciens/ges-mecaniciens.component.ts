import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Automobiliste} from "../../../services/models/automobiliste";
import {Mecanicien} from "../../../services/models/mecanicien";
import {ApiService} from "../../../services/services/api.service";
import {PageEvent} from "@angular/material/paginator";
import { MatDialog, MatDialogRef } from "@angular/material/dialog";
import {SupprimerMecanicien$Params} from "../../../services/fn/operations/supprimer-mecanicien";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-ges-mecaniciens',
  templateUrl: './ges-mecaniciens.component.html',
  styleUrls: ['./ges-mecaniciens.component.scss']
})
export class GesMecaniciensComponent  implements OnInit {
  mecaniciens: Mecanicien[] = [];
  displayedMecanicien: Mecanicien[] = [];
  pageSize = 7;
  pageIndex = 0;
  length = 0;
  @ViewChild('confirmDeleteTemplate') confirmDeleteTemplate!: TemplateRef<any>;
  dialogRef!: MatDialogRef<any>;
  constructor(private Service: ApiService,
              private toastr: ToastrService,
              private dialog: MatDialog,

  ) {}

  ngOnInit(): void {
    this.getMecaniciens();
  }
  onPageChange(event: PageEvent) {
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.updateDisplayedAutomobilistes();
  }

  private getMecaniciens(): void {
    this.Service.getAllMecanicien().subscribe(
      (list) => {
        this.mecaniciens = list;
        this.length = list.length;
        this.updateDisplayedAutomobilistes();
      },
      (error) => {
        console.error('Error loading mecaniciens:', error);
      }
    );
  }

  private updateDisplayedAutomobilistes() {
    const startIndex = this.pageIndex * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    this.displayedMecanicien = this.mecaniciens.slice(startIndex, endIndex);
  }
  openDialog(personneid?: number): void {
    this.dialogRef = this.dialog.open(this.confirmDeleteTemplate, {
      width: '400px',
    });

    this.dialogRef.afterClosed().subscribe(result => {
      if (result === true) {
        this.DeleteUser(personneid);
      }
    });
  }
  DeleteUser(personneid?: number) {
    const requestParams:  SupprimerMecanicien$Params = {
      id: personneid
    }
    this.Service.supprimerMecanicien$Response(requestParams).subscribe(
        (response) => {
          this.toastr.success('Mecanicien supprimé avec succès', 'succès!');
          this.getMecaniciens();
        },
        (error) => {
          this.toastr.error('Erreur lors de la suppression du Mecanicien', 'échoué!');
          console.error('Erreur lors de la suppression du Mecanicien:', error);
        }
    );
  }
}
