import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../services/services/api.service";
import {TokenService} from "../../services/token/token.service";
import {GetAllDemandeByAutomobiliste$Params} from "../../services/fn/operations/get-all-demande-by-automobiliste";
import {DemandeDepannageDto} from "../../services/models/demande-depannage-dto";

@Component({
  selector: 'app-historique',
  templateUrl: './historique.component.html',
  styleUrls: ['./historique.component.scss']
})
export class HistoriqueComponent implements OnInit{

  demandes: DemandeDepannageDto[] = [];
      constructor(
        private service : ApiService,
        private Token: TokenService,
      ) {}

  ngOnInit(): void {
        this.getAllHistorique();
  }


  private getAllHistorique() {
    const Id = this.Token.getIDFromLocalJwt();
    const Params: GetAllDemandeByAutomobiliste$Params = {
      id: Id,
    }
    this.service.getAllDemandeByAutomobiliste$Response(Params).subscribe(
        (response) => {
            console.log(response.body);
            this.demandes = response.body;
        },
        (error) => {
            console.error('Erreur lors de la récupération des demandes', error);
        }
        );
  }
}
