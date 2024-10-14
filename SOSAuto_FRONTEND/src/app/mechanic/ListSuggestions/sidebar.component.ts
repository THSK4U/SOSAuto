import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../services/services/api.service";
import {DemandeDepannageDto} from "../../services/models/demande-depannage-dto";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  Demandes: DemandeDepannageDto[] = [];

  constructor(
    private service: ApiService,
  ) {
  }

  ngOnInit(): void {
    this.findAllDemande();
  }

  private findAllDemande() {
    this.service.getAllDemande()
      .subscribe({
        next: (demande) => {
          this.Demandes = demande
            .filter(demande => demande.etat === 'A_FAIRE')
            .sort((a, b) => {
            const dateA = a.dateTime ? new Date(a.dateTime).getTime() : 0;
            const dateB = b.dateTime ? new Date(b.dateTime).getTime() : 0;
            return dateB - dateA;

          });

        },
        error: (err) => {
          console.error('Error fetching demands', err);
        }
      });
  }
}
