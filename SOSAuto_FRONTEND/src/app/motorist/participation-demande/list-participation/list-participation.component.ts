import { Component, OnDestroy, OnInit } from '@angular/core';
import { ApiService } from "../../../services/services/api.service";
import { TokenService } from "../../../services/token/token.service";
import { GetAllParticipationByIdAutomobilist$Params } from "../../../services/fn/operations/get-all-participation-by-id-automobilist";
import { interval, Subscription } from "rxjs";
import { switchMap, tap, catchError } from "rxjs/operators";
import { Observable } from 'rxjs';
import {
  GetAllParticipationByIdDemande$Params
} from "../../../services/fn/operations/get-all-participation-by-id-demande";
import {ActivatedRoute} from "@angular/router";
import {ParticipationDto} from "../../../services/models/participation-dto";
import {AcceptParticipation$Params} from "../../../services/fn/operations/accept-participation";
import {RejectParticipation$Params} from "../../../services/fn/operations/reject-participation";
import {AnnulerParticipation$Params} from "../../../services/fn/operations/annuler-participation";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-list-participation',
  templateUrl: './list-participation.component.html',
  styleUrls: ['./list-participation.component.scss']
})
export class ListParticipationComponent implements OnInit, OnDestroy {

  participations: ParticipationDto[] = [];
  private refreshSubscription?: Subscription;

  constructor(
    private service: ApiService,
    private tokenService: TokenService,
    private route: ActivatedRoute,
    private toastr: ToastrService,
  ) {}

  ngOnInit(): void {
    this.startAutoRefresh();
  }

  ngOnDestroy(): void {
    if (this.refreshSubscription) {
      this.refreshSubscription.unsubscribe();
    }
  }

  startAutoRefresh(): void {
    // 10 seconds
    this.refreshSubscription = interval(10000)
      .pipe(
        switchMap(() => this.getAllParticipationByID())
      )
      .subscribe(
        () => {
          console.log('Data refreshed');
        },
        error => {
          console.error('Error refreshing data:', error);
        }
      );
  }

  getAllParticipationByID(): Observable<any> {

    const requestParams: GetAllParticipationByIdDemande$Params = {
      id: Number(this.route.snapshot.paramMap.get('id')),
    };
    return this.service.getAllParticipationByIdDemande$Response(requestParams)
      .pipe(
        tap((List) => {
          if (List && List.body) {
            this.participations = List.body;
            console.log(List.body);
          } else {
            this.participations = [];
          }
          console.log(this.participations);
        }),
        catchError((error) => {
          console.error('Error fetching participations:', error);
          this.participations = [];
          throw error;
        })
      );
  }

  acceptOffer(id?: number) {
    if (!id) {
      console.error('ID de participation invalide');
      this.toastr.error('ID de participation invalide', 'Erreur!');
      return;
    }
    const request: AcceptParticipation$Params = {
      participationId: id,
    };
    this.service.acceptParticipation$Response(request).subscribe(
      (response) => {
        this.toastr.success('Offre acceptée avec succès', 'Succès!');
        console.log('Participation acceptée:', response);
        this.getAllParticipationByID().subscribe();
      },
      (error) => {
        this.toastr.error('Erreur lors de l\'acceptation de l\'offre', 'Erreur!');
        console.error('Erreur lors de l\'acceptation de la participation:', error);
      }
    );
  }

  cancelOffer(id?: number) {
    if (!id) {
      console.error('ID de participation invalide');
      this.toastr.error('ID de participation invalide', 'Erreur!');
      return;
    }
    const request: AnnulerParticipation$Params = {
      id: id
    };
    this.service.annulerParticipation$Response(request).subscribe(
      (response) => {
        this.toastr.success('Offre annulée avec succès', 'Succès!');
        console.log('Participation annulée:', response);
        this.getAllParticipationByID().subscribe();
      },
      (error) => {
        this.toastr.error('Erreur lors de l\'annulation de l\'offre', 'Erreur!');
        console.error('Erreur lors de l\'annulation de la participation:', error);
      }
    );
  }
}
