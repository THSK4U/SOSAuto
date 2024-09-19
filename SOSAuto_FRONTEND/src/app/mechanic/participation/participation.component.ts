import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../services/services/api.service";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {TokenService} from "../../services/token/token.service";
import {ParticipationDto} from "../../services/models/participation-dto";
import {CreerDemande$Params} from "../../services/fn/operations/creer-demande";
import {CreerParticipation$Params} from "../../services/fn/operations/creer-participation";
import {AnnulerParticipation$Params} from "../../services/fn/operations/annuler-participation";

@Component({
  selector: 'app-participation',
  templateUrl: './participation.component.html',
  styleUrls: ['./participation.component.scss']
})
export class ParticipationComponent implements OnInit{
  demandeid: number = 0;
  participation: ParticipationDto[] = [];
  createdParticipationId: number = 0;
  constructor(
    private service: ApiService,
    private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router,
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
        this.createdParticipationId = response.body.id!;
        console.log('Participation créée avec succès', this.createdParticipationId);
      },(error) => {
      console.error('La création de la demande a échoué:', error);
    }
    )
  }

  cancelRequest() {
    const requestParams: AnnulerParticipation$Params = {
            id: this.createdParticipationId
    }
      this.service.annulerParticipation$Response(requestParams).subscribe(
        (response) => {
          console.log('Participation annulée avec succès');
          this.router.navigate(['/mecanicien']);
        },
        (error) => {
          console.log("Participation non annulée", requestParams);
          console.error('L\'annulation de la participation a échoué:', error);
        }
      );

  }
}
