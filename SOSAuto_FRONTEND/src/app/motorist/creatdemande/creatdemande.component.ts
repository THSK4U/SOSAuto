import { Component } from '@angular/core';
import { ApiService } from '../../services/services/api.service';
import { CreerDemande$Params } from "../../services/fn/operations/creer-demande";
import { StrictHttpResponse } from "../../services/strict-http-response";
import { DemandeDepannageDto } from "../../services/models/demande-depannage-dto";
import { SharedDataService } from "../../services/services/share-data.service";

@Component({
  selector: 'app-creatdemande',
  templateUrl: './creatdemande.component.html',
  styleUrls: ['./creatdemande.component.scss']
})
export class CreatdemandeComponent {

  constructor(private service: ApiService, private sharedDataService: SharedDataService) {}

  onSubmit(): void {
    const location = this.sharedDataService.getUserLocation();

    if (location && location.lat && location.lng) {
      const requestParams: CreerDemande$Params = {
        body: {
          latitude: location.lat,
          longitude: location.lng,
          description: 'Hada test',
          automobiliste: {
            personneid: 4
          },
          panne: {
            panneid: 2
          }
        }
      };

      this.service.creerDemande$Response(requestParams).subscribe(
        (response: StrictHttpResponse<DemandeDepannageDto>) => {
        },
        (error) => {
          console.error('Request failed:', error);
        }
      );
    } else {
      console.error('User location is not available.');
      alert('Could not retrieve user location. Please make sure location services are enabled.');
    }
  }
}
