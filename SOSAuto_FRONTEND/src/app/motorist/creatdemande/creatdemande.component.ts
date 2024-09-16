import {Component, OnInit} from '@angular/core';
import { ApiService } from '../../services/services/api.service';
import { CreerDemande$Params } from "../../services/fn/operations/creer-demande";
import { StrictHttpResponse } from "../../services/strict-http-response";
import { DemandeDepannageDto } from "../../services/models/demande-depannage-dto";
import { SharedDataService } from "../../services/services/share-data.service";
import {PanneDto} from "../../services/models/panne-dto";
import {TokenService} from "../../services/token/token.service";

@Component({
  selector: 'app-creatdemande',
  templateUrl: './creatdemande.component.html',
  styleUrls: ['./creatdemande.component.scss']
})
export class CreatdemandeComponent implements OnInit{

  pannes: PanneDto[] = [];
  description: string = '';
  automobiliste: { personneid: number } = { personneid: 0 };
  panne: { panneid: number } = { panneid: 0 };

  constructor(private service: ApiService,
              private sharedDataService: SharedDataService,
              private tokenService: TokenService

  ) {}

  ngOnInit(): void {
   this.getPannes()
  }

  getPannes() {
    this.service.getAllPanne().subscribe((data: PanneDto[]) => {
      this.pannes = data;
    });
  }

  onSubmit(): void {
    const location = this.sharedDataService.getUserLocation();
    const Id = this.tokenService.getIDFromJwt(this.tokenService.token)

    if (location && location.lat && location.lng) {
      const requestParams: CreerDemande$Params = {
        body: {
          latitude: location.lat,
          longitude: location.lng,
          description: this.description,
          automobiliste: {personneid: Id},
          panne: {
            panneid: this.panne?.panneid
          }}};

      this.service.creerDemande$Response(requestParams).subscribe(
        (response: StrictHttpResponse<DemandeDepannageDto>) => {
          console.log('Demande créée avec succès', response.body);
          window.location.reload();
        },
        (error) => {
          console.error('La création de la demande a échoué:', error);
        }
      );
    } else {
      console.error('La localisation de l\'utilisateur n\'est pas disponible.');
      alert('Impossible de récupérer la localisation de l\'utilisateur. Veuillez vous assurer que les services de localisation sont activés.');
    }
  }

}
