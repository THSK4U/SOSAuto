import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../services/services/api.service";
import {TokenService} from "../../services/token/token.service";
import {Mecanicien} from "../../services/models/mecanicien";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit{
  mecanicien: Mecanicien | null = null;

  constructor(
    private service: ApiService,
    private Token: TokenService,
  ) {}

  ngOnInit(): void {
    this.getByID();
  }


  getByID() {
    const Id = this.Token.getIDFromLocalJwt();
    this.service.getMecanicienById$Response({ id: Id }).subscribe(
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
}
