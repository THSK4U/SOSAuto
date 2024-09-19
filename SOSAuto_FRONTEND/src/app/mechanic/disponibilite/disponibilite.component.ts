import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../services/services/api.service";
import {Router} from "@angular/router";
import {TokenService} from "../../services/token/token.service";
import {MettreAjourDisponibilite$Params} from "../../services/fn/operations/mettre-ajour-disponibilite";
import {MecanicienDto} from "../../services/models/mecanicien-dto";

@Component({
  selector: 'app-disponibilite',
  templateUrl: './disponibilite.component.html',
  styleUrls: ['./disponibilite.component.scss']
})
export class DisponibiliteComponent {
  mecanicien: MecanicienDto = {};

  constructor(
    private router: Router,
    private Service: ApiService,
    private Token : TokenService
  ) {
  }


  toggleDisponibilite(): void {
    this.mecanicien.disponible = this.mecanicien.disponible === 'DISPONIBLE' ? 'INDISPONIBLE' : 'DISPONIBLE';
    this.updateDisponibilite();
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
        console.log('تم تحديث الحالة بنجاح:', data);
      },
      (error) => {
        console.error('خطأ في تحديث الحالة:', error);
      }
    );
  }
}
