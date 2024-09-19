import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../../services/services/api.service";
import {Router} from "@angular/router";
import {TokenService} from "../../../services/token/token.service";
import {ParticipationDto} from "../../../services/models/participation-dto";

@Component({
  selector: 'app-list-participation',
  templateUrl: './list-participation.component.html',
  styleUrls: ['./list-participation.component.scss']
})
export class ListParticipationComponent implements OnInit{

  participations: ParticipationDto[] = [];

  constructor(
      private service: ApiService,
      private router: Router,
      private Token: TokenService
  ) {
  }

  ngOnInit(): void {
    const Id = this.Token.getIDFromLocalJwt();
    this.service.getAllParticipationByIdMecanicien({id: Id}).subscribe(
        (participations) => {
            this.participations = participations;
        },
        (error) => {
            console.error('Erreur lors de la récupération des participations', error);
        }
    );


  }

}
