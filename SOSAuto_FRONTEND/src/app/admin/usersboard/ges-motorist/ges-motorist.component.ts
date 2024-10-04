import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Automobiliste} from "../../../services/models/automobiliste";
import {Mecanicien} from "../../../services/models/mecanicien";
import {ApiService} from "../../../services/services/api.service";
import {PageEvent} from "@angular/material/paginator";
import {ToastrService} from "ngx-toastr";
import {MatDialog, MatDialogRef} from "@angular/material/dialog";
import {SupprimerMecanicien$Params} from "../../../services/fn/operations/supprimer-mecanicien";
import {SupprimerAutomobiliste$Params} from "../../../services/fn/operations/supprimer-automobiliste";

@Component({
  selector: 'app-ges-motorist',
  templateUrl: './ges-motorist.component.html',
  styleUrls: ['./ges-motorist.component.scss']
})
export class GesMotoristComponent  implements OnInit {
  automobilistes: Automobiliste[] = [];
  displayedAutomobilistes: Automobiliste[] = [];
  pageSize = 7;
  pageIndex = 0;
  length = 0;
  @ViewChild('confirmDeleteTemplate') confirmDeleteTemplate!: TemplateRef<any>;
  dialogRef!: MatDialogRef<any>;
  constructor(private Service: ApiService,
              private toastr: ToastrService,
              private dialog: MatDialog,) {}

  ngOnInit(): void {
    this.getUsers();
  }
  onPageChange(event: PageEvent) {
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.updateDisplayedAutomobilistes();
  }
  private getUsers(): void {
    this.Service.getAllAutomobiliste().subscribe(
      (data) => {
        this.automobilistes = data;
        this.length = data.length;
        this.updateDisplayedAutomobilistes();
      },
      (error) => {
        console.error('Error loading users:', error);
      }
    );
  }

  private updateDisplayedAutomobilistes() {
    const startIndex = this.pageIndex * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    this.displayedAutomobilistes = this.automobilistes.slice(startIndex, endIndex);
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
    const requestParams:  SupprimerAutomobiliste$Params = {
      id: personneid
    }
    this.Service.supprimerAutomobiliste$Response(requestParams).subscribe(
      (response) => {
        this.toastr.success('Automobiliste supprimé avec succès', 'succès!');
        this.getUsers();
      },
      (error) => {
        this.toastr.error('Erreur lors de la suppression du Automobilistes', 'échoué!');
        console.error('Erreur lors de la suppression du Automobilistes:', error);
      }
    );
  }
}
