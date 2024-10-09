import {Component, OnInit} from '@angular/core';
import {MecanicienDto} from "../../services/models/mecanicien-dto";
import {ActivatedRoute, Router} from "@angular/router";
import {ApiService} from "../../services/services/api.service";
import {GetMecanicienById$Params} from "../../services/fn/operations/get-mecanicien-by-id";
import {AddNotation$Params} from "../../services/fn/operations/add-notation";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-notation-page',
  templateUrl: './notation-page.component.html',
  styleUrls: ['./notation-page.component.scss']
})
export class NotationPageComponent implements OnInit {
  mecanicien: MecanicienDto | null = null;
  personneid?: number;
  selectedRating: number = 0;

  constructor(
    private route: ActivatedRoute,
    private Service: ApiService,
    private toastr: ToastrService,
    private router: Router,
  ) {}

  ngOnInit(): void {
      this.personneid = Number(this.route.snapshot.paramMap.get('personneid'));
      this.getMechanicInfo();;
  }

  private getMechanicInfo(): void {


    const params: GetMecanicienById$Params = {
      id: this.personneid,
    }
    this.Service.getMecanicienById$Response(params).subscribe(
      (response) => {
        this.mecanicien = response.body;
      },
      error => {
        console.error('Erreur lors de la récupération des infos du mécanicien :', error);
      }
    );
  }
  selectRating(stars: number): void {
    this.selectedRating = stars;
  }

  submitRating(): void {
    const paramRes = {
      id: this.personneid,
      body: this.selectedRating
    };
    this.Service.addNotation$Response(paramRes).subscribe(
      response => {
        this.toastr.success('Votre évaluation a été soumise avec succès', 'Succès!');
        this.router.navigate(['/automobiliste']);
        console.log('Notation submitted successfully:', response);
      },
      error => {
        this.toastr.error('La soumission de votre évaluation a échoué', 'Échoué!');
        console.error('Error submitting notation:', error);
      }
    );
  }
}
