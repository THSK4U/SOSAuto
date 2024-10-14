import {Component, OnDestroy, OnInit} from '@angular/core';
import {ApiService} from "../../services/services/api.service";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {TokenService} from "../../services/token/token.service";
import {ParticipationDto} from "../../services/models/participation-dto";
import {CreerParticipation$Params} from "../../services/fn/operations/creer-participation";
import {AnnulerParticipation$Params} from "../../services/fn/operations/annuler-participation";
import {ToastrService} from "ngx-toastr";
import {GetParticipationById$Params} from "../../services/fn/operations/get-participation-by-id";
import {interval, Subscription} from "rxjs";
import {switchMap} from "rxjs/operators";

@Component({
  selector: 'app-participation',
  templateUrl: './participation.component.html',
  styleUrls: ['./participation.component.scss']
})
export class ParticipationComponent implements OnInit,OnDestroy{
  demandeid: number = 0;
  participation: ParticipationDto[] = [];
  createdParticipationId: number = 0;
  refreshSubscription?: Subscription;


  constructor(
    private service: ApiService,
    private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router,
    private tokenService: TokenService,
    private toastr: ToastrService
    ){}

  ngOnInit(): void {
    this.demandeid = Number(this.route.snapshot.paramMap.get('demandeid'));
    this.creerParticipation();
  }

  ngOnDestroy(): void {
    if (this.refreshSubscription) {
      this.refreshSubscription.unsubscribe();
    }
  }

  startAutoRefresh(participationId: number): void {
    // Refresh every 10 seconds
    this.refreshSubscription = interval(5000)
      .pipe(switchMap(() => this.checkParticipationStatus(participationId)))
      .subscribe();
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
        this.toastr.success('Participation créée avec succès', 'succès!');
        console.log('Participation créée avec succès', this.createdParticipationId);
        this.startAutoRefresh(this.createdParticipationId);
      },(error) => {
        this.toastr.error('Erreur lors de la mise à jour de la disponibilité', 'Erreur!');
        console.error('La création de la demande a échoué:', error);
        this.router.navigate(['/mecanicien']);
    }
    )
  }

  cancelRequest() {
    const requestParams: AnnulerParticipation$Params = {
            id: this.createdParticipationId
    }
      this.service.annulerParticipation$Response(requestParams).subscribe(
        (response) => {
          this.toastr.warning('La participation a été annulée', 'Avertissement!');
          console.log('Participation annulée avec succès');
          this.router.navigate(['/mecanicien']);
        },
        (error) => {
          this.toastr.error('L\'annulation de la participation a échoué', 'Erreur!');
          console.error('L\'annulation de la participation a échoué:', error);
        }
      );
  }

  checkParticipationStatus(participationId: number) {
    const requestParams: GetParticipationById$Params = {
      id: participationId
    };
    return this.service.getParticipationById$Response(requestParams).pipe(
      switchMap((response) => {
        const participation = response.body;

        if (!participation) {
          this.toastr.error('Participation non trouvée', 'Erreur!');
          this.router.navigate(['/mecanicien']);
          return [];
        }

        if (participation.status === 'ACCEPTE') {
          this.toastr.success('Votre offre a été acceptée par l\'automobiliste', 'Succès!');
          if(participation.demande){
            this.router.navigate(['demande-detail', participation.demande.demandeid]);

          }
        } else if (participation.status === 'ANNULER') {
          this.toastr.warning('Votre participation a été annulée par l\'automobiliste', 'Avertissement!');
          this.router.navigate(['/mecanicien']);
        }
        return [];
      })
    );
  }
}
