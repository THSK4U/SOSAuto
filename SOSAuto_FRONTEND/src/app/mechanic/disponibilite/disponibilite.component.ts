import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../services/services/api.service";
import {Router} from "@angular/router";
import {TokenService} from "../../services/token/token.service";
import {MettreAjourDisponibilite$Params} from "../../services/fn/operations/mettre-ajour-disponibilite";
import {MecanicienDto} from "../../services/models/mecanicien-dto";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-disponibilite',
  templateUrl: './disponibilite.component.html',
  styleUrls: ['./disponibilite.component.scss']
})
export class DisponibiliteComponent implements OnInit{
  mecanicien: MecanicienDto = {};

  constructor(
    private Service: ApiService,
    private Token : TokenService,
    private toastr: ToastrService
  ) {
  }
  ngOnInit(): void {
    this.loadMecanicienData();
  }

  toggleDisponibilite(): void {
    this.mecanicien.disponible = this.mecanicien.disponible === 'DISPONIBLE' ? 'INDISPONIBLE' : 'DISPONIBLE';
    this.updateDisponibilite();
  }

  private loadMecanicienData(): void {
      const Id = this.Token.getIDFromLocalJwt();
      this.Service.getMecanicienById$Response({ id: Id }).subscribe(
        (response) => {
          if (response.body) {
            this.mecanicien = response.body;
          }
        },
        (error) => {
          console.error('Erreur lors de la récupération des données du mécanicien:', error);
        }
      );
  }


  private updateDisponibilite(): void {
    const Id = this.Token.getIDFromLocalJwt();
    const requestParams: MettreAjourDisponibilite$Params = {
      id: Id,
      body: {
        disponible: this.mecanicien.disponible
      }
    };

    this.Service.mettreAjourDisponibilite$Response(requestParams).subscribe(
      (data: any) => {
        this.toastr.success('La disponibilité a été mise à jour avec succès', 'succès!');

        console.log('La disponibilité a été mise à jour avec succès:', data);
      },
      (error) => {
        this.toastr.error('Erreur lors de la mise à jour de la disponibilité', 'Erreur!');
        console.error('Erreur lors de la mise à jour de la disponibilité:', error);
      }
    );
  }
}
