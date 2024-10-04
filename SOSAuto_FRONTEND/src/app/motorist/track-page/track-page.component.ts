import { Component, OnInit } from '@angular/core';
import * as mapboxgl from 'mapbox-gl';
import { ApiService } from '../../services/services/api.service';
import { SharedDataService } from '../../services/token/share-data.service';
import {GetMecanicienById$Params} from "../../services/fn/operations/get-mecanicien-by-id";
import {TokenService} from "../../services/token/token.service";
import {MecanicienDto} from "../../services/models/mecanicien-dto";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-track-page',
  templateUrl: './track-page.component.html',
  styleUrls: ['./track-page.component.scss']
})
export class TrackPageComponent implements OnInit {

  mecanicien?: MecanicienDto;
  public progress: number = 0;
  public estimatedTime: string = 'Non disponible';

  constructor(private apiService: ApiService,
              private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.getMechanicInfo();
    this.trackMechanicProgress();
  }

  private getMechanicInfo(): void {
    const personneid = this.route.snapshot.paramMap.get('id');

    const params: GetMecanicienById$Params = {
      id: parseInt(personneid!),
    }
    this.apiService.getMecanicienById$Response(params).subscribe(
      (response) => {
          this.mecanicien = response.body;
      },
      error => {
        console.error('Erreur lors de la récupération des infos du mécanicien :', error);
      }
    );
  }


  private trackMechanicProgress(): void {
    setInterval(() => {
      this.progress = Math.min(this.progress + 5, 100);
      this.estimatedTime = this.calculateEstimatedTime();
    }, 1000);
  }

  private calculateEstimatedTime(): string {
    const remainingTime = Math.round((100 - this.progress) / 5);
    return `${remainingTime} minutes`;
  }

  public cancelRequest(): void {
    console.log('Demande annulée');
    alert('La demande a été annulée avec succès');
  }

  public contactMechanic(): void {
    if (this.mecanicien) {
      window.open(`tel:${this.mecanicien}`);
    } else {
      alert('Numéro de téléphone non disponible');
    }
  }
}
