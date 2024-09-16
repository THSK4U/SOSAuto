import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../services/services/api.service";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";
import {TokenService} from "../../services/token/token.service";
import {ParticipationDto} from "../../services/models/participation-dto";
import {CreerDemande$Params} from "../../services/fn/operations/creer-demande";
import {CreerParticipation$Params} from "../../services/fn/operations/creer-participation";

@Component({
  selector: 'app-participation',
  templateUrl: './participation.component.html',
  styleUrls: ['./participation.component.scss']
})
export class ParticipationComponent implements OnInit{
  demandeid: number = 0;
  participation: ParticipationDto[] = [];
  constructor(
    private service: ApiService,
    private http: HttpClient,
    private route: ActivatedRoute,
    private tokenService: TokenService,
    ){}

  ngOnInit(): void {
    this.demandeid = Number(this.route.snapshot.paramMap.get('demandeid'));
    this.creerParticipation()
  }

  creerParticipation(){
    const Id = this.tokenService.getIDFromLocalJwt()
    const requestParams: CreerParticipation$Params = {
      body: {
        demande: {demandeid: this.demandeid},
        mecanicien: {personneid: Id}
      }};
    console.log(requestParams.body);
    this.service.creerParticipation$Response(requestParams).subscribe(
      (response) => {
        console.log('Participation créée avec succès', response.body);
      },(error) => {
      console.error('La création de la demande a échoué:', error);
    }
    )
  }
}
