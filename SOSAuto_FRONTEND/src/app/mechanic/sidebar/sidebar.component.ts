import {Component, OnInit} from '@angular/core';
import {Mecanicien} from "../../services/models/mecanicien";
import {ApiService} from "../../services/services/api.service";
import {Router} from "@angular/router";
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
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.findAllDemande();
  }

  private findAllDemande() {
    this.service.getAllDemande()
      .subscribe({
        next: (demande) => {
          this.Demandes = demande;
        },
        error: (err) => {
          console.error('Error fetching demands', err);
        }
      });
  }
}
