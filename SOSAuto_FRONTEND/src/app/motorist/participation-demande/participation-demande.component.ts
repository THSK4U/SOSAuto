import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../services/services/api.service";
import {TokenService} from "../../services/token/token.service";
import {SupprimerDemande$Params} from "../../services/fn/operations/supprimer-demande";
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'app-participation-demande',
    templateUrl: './participation-demande.component.html',
    styleUrls: ['./participation-demande.component.scss']
})
export class ParticipationDemandeComponent {

constructor(
      private service: ApiService,
      private tokenService: TokenService,
      private route: ActivatedRoute
) {
}

  cancelRequest() {
    const Para: SupprimerDemande$Params = {
      id: Number(this.route.snapshot.paramMap.get('id'))
    };
    this.service.supprimerDemande$Response(Para).subscribe(
      (response) => {
        console.log('Demande supprimée avec succès');
      },
      (error) => {
        console.error('Erreur lors de la suppression de la demande', error);
      }
    );
  }
}