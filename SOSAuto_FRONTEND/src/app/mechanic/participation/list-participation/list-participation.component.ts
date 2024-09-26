import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../../services/services/api.service";
import {Router} from "@angular/router";
import {TokenService} from "../../../services/token/token.service";
import {ParticipationDto} from "../../../services/models/participation-dto";
import {ParticipationComponent} from "../participation.component";
import {AnnulerParticipation$Params} from "../../../services/fn/operations/annuler-participation";
import {ToastrService} from "ngx-toastr";

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
      private Token: TokenService,
      private toastr: ToastrService

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

  cancelRequest(id: number | undefined) {
    const requestParams: AnnulerParticipation$Params = {
      id: id!
    }
    this.service.annulerParticipation$Response(requestParams).subscribe(
      (response) => {
        this.toastr.warning('La participation a été annulée', 'Avertissement!');
        console.log('Participation annulée avec succès');
          window.location.reload();
      },
      (error) => {
        this.toastr.error('L\'annulation de la participation a échoué', 'Erreur!');
        console.error('L\'annulation de la participation a échoué:', error);
      }
    );
  }
}
