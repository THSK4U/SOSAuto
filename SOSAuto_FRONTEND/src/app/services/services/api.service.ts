/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { AdministrateurDto } from '../models/administrateur-dto';
import { AutomobilisteDto } from '../models/automobiliste-dto';
import { creerAdministrateur } from '../fn/operations/creer-administrateur';
import { CreerAdministrateur$Params } from '../fn/operations/creer-administrateur';
import { creerAutomobiliste } from '../fn/operations/creer-automobiliste';
import { CreerAutomobiliste$Params } from '../fn/operations/creer-automobiliste';
import { creerDemande } from '../fn/operations/creer-demande';
import { CreerDemande$Params } from '../fn/operations/creer-demande';
import { creerMecanicien } from '../fn/operations/creer-mecanicien';
import { CreerMecanicien$Params } from '../fn/operations/creer-mecanicien';
import { creerPanne } from '../fn/operations/creer-panne';
import { CreerPanne$Params } from '../fn/operations/creer-panne';
import { creerParticipation } from '../fn/operations/creer-participation';
import { CreerParticipation$Params } from '../fn/operations/creer-participation';
import { creerVehicule } from '../fn/operations/creer-vehicule';
import { CreerVehicule$Params } from '../fn/operations/creer-vehicule';
import { DemandeDepannageDto } from '../models/demande-depannage-dto';
import { getAllAutomobiliste } from '../fn/operations/get-all-automobiliste';
import { GetAllAutomobiliste$Params } from '../fn/operations/get-all-automobiliste';
import { getAllDemande } from '../fn/operations/get-all-demande';
import { GetAllDemande$Params } from '../fn/operations/get-all-demande';
import { getAllMecanicien } from '../fn/operations/get-all-mecanicien';
import { GetAllMecanicien$Params } from '../fn/operations/get-all-mecanicien';
import { getAllMecanicienDesponible } from '../fn/operations/get-all-mecanicien-desponible';
import { GetAllMecanicienDesponible$Params } from '../fn/operations/get-all-mecanicien-desponible';
import { getAllPanne } from '../fn/operations/get-all-panne';
import { GetAllPanne$Params } from '../fn/operations/get-all-panne';
import { getAllParticipation } from '../fn/operations/get-all-participation';
import { GetAllParticipation$Params } from '../fn/operations/get-all-participation';
import { getAllVehicule } from '../fn/operations/get-all-vehicule';
import { GetAllVehicule$Params } from '../fn/operations/get-all-vehicule';
import { getAutomobilisteById } from '../fn/operations/get-automobiliste-by-id';
import { GetAutomobilisteById$Params } from '../fn/operations/get-automobiliste-by-id';
import { getDemandeById } from '../fn/operations/get-demande-by-id';
import { GetDemandeById$Params } from '../fn/operations/get-demande-by-id';
import { getMecanicienById } from '../fn/operations/get-mecanicien-by-id';
import { GetMecanicienById$Params } from '../fn/operations/get-mecanicien-by-id';
import { getPanneById } from '../fn/operations/get-panne-by-id';
import { GetPanneById$Params } from '../fn/operations/get-panne-by-id';
import { getParticipationById } from '../fn/operations/get-participation-by-id';
import { GetParticipationById$Params } from '../fn/operations/get-participation-by-id';
import { getVehiculeById } from '../fn/operations/get-vehicule-by-id';
import { GetVehiculeById$Params } from '../fn/operations/get-vehicule-by-id';
import { MecanicienDto } from '../models/mecanicien-dto';
import { mettreAJourAdministrateur } from '../fn/operations/mettre-a-jour-administrateur';
import { MettreAJourAdministrateur$Params } from '../fn/operations/mettre-a-jour-administrateur';
import { mettreAjourAutomobiliste } from '../fn/operations/mettre-ajour-automobiliste';
import { MettreAjourAutomobiliste$Params } from '../fn/operations/mettre-ajour-automobiliste';
import { mettreAjourDemande } from '../fn/operations/mettre-ajour-demande';
import { MettreAjourDemande$Params } from '../fn/operations/mettre-ajour-demande';
import { mettreAjourDisponibilite } from '../fn/operations/mettre-ajour-disponibilite';
import { MettreAjourDisponibilite$Params } from '../fn/operations/mettre-ajour-disponibilite';
import { mettreAjourMecanicien } from '../fn/operations/mettre-ajour-mecanicien';
import { MettreAjourMecanicien$Params } from '../fn/operations/mettre-ajour-mecanicien';
import { mettreAjourPanne } from '../fn/operations/mettre-ajour-panne';
import { MettreAjourPanne$Params } from '../fn/operations/mettre-ajour-panne';
import { mettreAjourParticipation } from '../fn/operations/mettre-ajour-participation';
import { MettreAjourParticipation$Params } from '../fn/operations/mettre-ajour-participation';
import { mettreAjourVehicule } from '../fn/operations/mettre-ajour-vehicule';
import { MettreAjourVehicule$Params } from '../fn/operations/mettre-ajour-vehicule';
import { PanneDto } from '../models/panne-dto';
import { ParticipationDto } from '../models/participation-dto';
import { supprimerAdministrateur } from '../fn/operations/supprimer-administrateur';
import { SupprimerAdministrateur$Params } from '../fn/operations/supprimer-administrateur';
import { supprimerAutomobiliste } from '../fn/operations/supprimer-automobiliste';
import { SupprimerAutomobiliste$Params } from '../fn/operations/supprimer-automobiliste';
import { supprimerDemande } from '../fn/operations/supprimer-demande';
import { SupprimerDemande$Params } from '../fn/operations/supprimer-demande';
import { supprimerMecanicien } from '../fn/operations/supprimer-mecanicien';
import { SupprimerMecanicien$Params } from '../fn/operations/supprimer-mecanicien';
import { supprimerPanne } from '../fn/operations/supprimer-panne';
import { SupprimerPanne$Params } from '../fn/operations/supprimer-panne';
import { supprimerParticipation } from '../fn/operations/supprimer-participation';
import { SupprimerParticipation$Params } from '../fn/operations/supprimer-participation';
import { supprimerVehicule } from '../fn/operations/supprimer-vehicule';
import { SupprimerVehicule$Params } from '../fn/operations/supprimer-vehicule';
import { VehiculeDto } from '../models/vehicule-dto';

@Injectable({ providedIn: 'root' })
export class ApiService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `creerAdministrateur()` */
  static readonly CreerAdministrateurPath = '/Administrateur/create';

  /**
   * POST Administrateur/create.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `creerAdministrateur()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerAdministrateur$Response(params: CreerAdministrateur$Params, context?: HttpContext): Observable<StrictHttpResponse<AdministrateurDto>> {
    return creerAdministrateur(this.http, this.rootUrl, params, context);
  }

  /**
   * POST Administrateur/create.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `creerAdministrateur$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerAdministrateur(params: CreerAdministrateur$Params, context?: HttpContext): Observable<AdministrateurDto> {
    return this.creerAdministrateur$Response(params, context).pipe(
      map((r: StrictHttpResponse<AdministrateurDto>): AdministrateurDto => r.body)
    );
  }

  /** Path part for operation `supprimerAdministrateur()` */
  static readonly SupprimerAdministrateurPath = '/Administrateur/delete/{id}';

  /**
   * DELETE Administrateur/delete/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `supprimerAdministrateur()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerAdministrateur$Response(params: SupprimerAdministrateur$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return supprimerAdministrateur(this.http, this.rootUrl, params, context);
  }

  /**
   * DELETE Administrateur/delete/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `supprimerAdministrateur$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerAdministrateur(params: SupprimerAdministrateur$Params, context?: HttpContext): Observable<void> {
    return this.supprimerAdministrateur$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `mettreAJourAdministrateur()` */
  static readonly MettreAJourAdministrateurPath = '/Administrateur/update/{id}';

  /**
   * PUT Administrateur/update/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `mettreAJourAdministrateur()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAJourAdministrateur$Response(params: MettreAJourAdministrateur$Params, context?: HttpContext): Observable<StrictHttpResponse<AdministrateurDto>> {
    return mettreAJourAdministrateur(this.http, this.rootUrl, params, context);
  }

  /**
   * PUT Administrateur/update/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `mettreAJourAdministrateur$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAJourAdministrateur(params: MettreAJourAdministrateur$Params, context?: HttpContext): Observable<AdministrateurDto> {
    return this.mettreAJourAdministrateur$Response(params, context).pipe(
      map((r: StrictHttpResponse<AdministrateurDto>): AdministrateurDto => r.body)
    );
  }

  /** Path part for operation `getAllAutomobiliste()` */
  static readonly GetAllAutomobilistePath = '/Automobiliste';

  /**
   * GET Automobiliste.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllAutomobiliste()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllAutomobiliste$Response(params?: GetAllAutomobiliste$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<AutomobilisteDto>>> {
    return getAllAutomobiliste(this.http, this.rootUrl, params, context);
  }

  /**
   * GET Automobiliste.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllAutomobiliste$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllAutomobiliste(params?: GetAllAutomobiliste$Params, context?: HttpContext): Observable<Array<AutomobilisteDto>> {
    return this.getAllAutomobiliste$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<AutomobilisteDto>>): Array<AutomobilisteDto> => r.body)
    );
  }

  /** Path part for operation `creerAutomobiliste()` */
  static readonly CreerAutomobilistePath = '/Automobiliste/Creer';

  /**
   * POST Automobiliste/Creer.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `creerAutomobiliste()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerAutomobiliste$Response(params: CreerAutomobiliste$Params, context?: HttpContext): Observable<StrictHttpResponse<AutomobilisteDto>> {
    return creerAutomobiliste(this.http, this.rootUrl, params, context);
  }

  /**
   * POST Automobiliste/Creer.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `creerAutomobiliste$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerAutomobiliste(params: CreerAutomobiliste$Params, context?: HttpContext): Observable<AutomobilisteDto> {
    return this.creerAutomobiliste$Response(params, context).pipe(
      map((r: StrictHttpResponse<AutomobilisteDto>): AutomobilisteDto => r.body)
    );
  }

  /** Path part for operation `supprimerAutomobiliste()` */
  static readonly SupprimerAutomobilistePath = '/Automobiliste/Delete/{id}';

  /**
   * DELETE Automobiliste/Delete/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `supprimerAutomobiliste()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerAutomobiliste$Response(params: SupprimerAutomobiliste$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return supprimerAutomobiliste(this.http, this.rootUrl, params, context);
  }

  /**
   * DELETE Automobiliste/Delete/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `supprimerAutomobiliste$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerAutomobiliste(params: SupprimerAutomobiliste$Params, context?: HttpContext): Observable<void> {
    return this.supprimerAutomobiliste$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `mettreAjourAutomobiliste()` */
  static readonly MettreAjourAutomobilistePath = '/Automobiliste/MettreAjour/{id}';

  /**
   * PUT Automobiliste/MettreAjour/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `mettreAjourAutomobiliste()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourAutomobiliste$Response(params: MettreAjourAutomobiliste$Params, context?: HttpContext): Observable<StrictHttpResponse<AutomobilisteDto>> {
    return mettreAjourAutomobiliste(this.http, this.rootUrl, params, context);
  }

  /**
   * PUT Automobiliste/MettreAjour/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `mettreAjourAutomobiliste$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourAutomobiliste(params: MettreAjourAutomobiliste$Params, context?: HttpContext): Observable<AutomobilisteDto> {
    return this.mettreAjourAutomobiliste$Response(params, context).pipe(
      map((r: StrictHttpResponse<AutomobilisteDto>): AutomobilisteDto => r.body)
    );
  }

  /** Path part for operation `getAutomobilisteById()` */
  static readonly GetAutomobilisteByIdPath = '/Automobiliste/{id}';

  /**
   * GET Automobiliste/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAutomobilisteById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAutomobilisteById$Response(params: GetAutomobilisteById$Params, context?: HttpContext): Observable<StrictHttpResponse<AutomobilisteDto>> {
    return getAutomobilisteById(this.http, this.rootUrl, params, context);
  }

  /**
   * GET Automobiliste/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAutomobilisteById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAutomobilisteById(params: GetAutomobilisteById$Params, context?: HttpContext): Observable<AutomobilisteDto> {
    return this.getAutomobilisteById$Response(params, context).pipe(
      map((r: StrictHttpResponse<AutomobilisteDto>): AutomobilisteDto => r.body)
    );
  }

  /** Path part for operation `getAllDemande()` */
  static readonly GetAllDemandePath = '/DemandeDepannage';

  /**
   * GET DemandeDepannage.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllDemande()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllDemande$Response(params?: GetAllDemande$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<DemandeDepannageDto>>> {
    return getAllDemande(this.http, this.rootUrl, params, context);
  }

  /**
   * GET DemandeDepannage.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllDemande$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllDemande(params?: GetAllDemande$Params, context?: HttpContext): Observable<Array<DemandeDepannageDto>> {
    return this.getAllDemande$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<DemandeDepannageDto>>): Array<DemandeDepannageDto> => r.body)
    );
  }

  /** Path part for operation `creerDemande()` */
  static readonly CreerDemandePath = '/DemandeDepannage/Creer';

  /**
   * POST DemandeDepannage/Creer.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `creerDemande()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerDemande$Response(params: CreerDemande$Params, context?: HttpContext): Observable<StrictHttpResponse<DemandeDepannageDto>> {
    return creerDemande(this.http, this.rootUrl, params, context);
  }

  /**
   * POST DemandeDepannage/Creer.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `creerDemande$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerDemande(params: CreerDemande$Params, context?: HttpContext): Observable<DemandeDepannageDto> {
    return this.creerDemande$Response(params, context).pipe(
      map((r: StrictHttpResponse<DemandeDepannageDto>): DemandeDepannageDto => r.body)
    );
  }

  /** Path part for operation `supprimerDemande()` */
  static readonly SupprimerDemandePath = '/DemandeDepannage/Delete/{id}';

  /**
   * DELETE DemandeDepannage/Delete/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `supprimerDemande()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerDemande$Response(params: SupprimerDemande$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return supprimerDemande(this.http, this.rootUrl, params, context);
  }

  /**
   * DELETE DemandeDepannage/Delete/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `supprimerDemande$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerDemande(params: SupprimerDemande$Params, context?: HttpContext): Observable<void> {
    return this.supprimerDemande$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `mettreAjourDemande()` */
  static readonly MettreAjourDemandePath = '/DemandeDepannage/MettreAjour/{id}';

  /**
   * PUT DemandeDepannage/MettreAjour/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `mettreAjourDemande()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourDemande$Response(params: MettreAjourDemande$Params, context?: HttpContext): Observable<StrictHttpResponse<DemandeDepannageDto>> {
    return mettreAjourDemande(this.http, this.rootUrl, params, context);
  }

  /**
   * PUT DemandeDepannage/MettreAjour/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `mettreAjourDemande$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourDemande(params: MettreAjourDemande$Params, context?: HttpContext): Observable<DemandeDepannageDto> {
    return this.mettreAjourDemande$Response(params, context).pipe(
      map((r: StrictHttpResponse<DemandeDepannageDto>): DemandeDepannageDto => r.body)
    );
  }

  /** Path part for operation `getDemandeById()` */
  static readonly GetDemandeByIdPath = '/DemandeDepannage/{id}';

  /**
   * GET DemandeDepannage/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getDemandeById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getDemandeById$Response(params: GetDemandeById$Params, context?: HttpContext): Observable<StrictHttpResponse<DemandeDepannageDto>> {
    return getDemandeById(this.http, this.rootUrl, params, context);
  }

  /**
   * GET DemandeDepannage/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getDemandeById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getDemandeById(params: GetDemandeById$Params, context?: HttpContext): Observable<DemandeDepannageDto> {
    return this.getDemandeById$Response(params, context).pipe(
      map((r: StrictHttpResponse<DemandeDepannageDto>): DemandeDepannageDto => r.body)
    );
  }

  /** Path part for operation `getAllMecanicien()` */
  static readonly GetAllMecanicienPath = '/Mecanicien';

  /**
   * GET Mecanicien.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllMecanicien()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllMecanicien$Response(params?: GetAllMecanicien$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<MecanicienDto>>> {
    return getAllMecanicien(this.http, this.rootUrl, params, context);
  }

  /**
   * GET Mecanicien.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllMecanicien$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllMecanicien(params?: GetAllMecanicien$Params, context?: HttpContext): Observable<Array<MecanicienDto>> {
    return this.getAllMecanicien$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<MecanicienDto>>): Array<MecanicienDto> => r.body)
    );
  }

  /** Path part for operation `creerMecanicien()` */
  static readonly CreerMecanicienPath = '/Mecanicien/Creer';

  /**
   * POST Mecanicien/Creer.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `creerMecanicien()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerMecanicien$Response(params: CreerMecanicien$Params, context?: HttpContext): Observable<StrictHttpResponse<MecanicienDto>> {
    return creerMecanicien(this.http, this.rootUrl, params, context);
  }

  /**
   * POST Mecanicien/Creer.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `creerMecanicien$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerMecanicien(params: CreerMecanicien$Params, context?: HttpContext): Observable<MecanicienDto> {
    return this.creerMecanicien$Response(params, context).pipe(
      map((r: StrictHttpResponse<MecanicienDto>): MecanicienDto => r.body)
    );
  }

  /** Path part for operation `supprimerMecanicien()` */
  static readonly SupprimerMecanicienPath = '/Mecanicien/Delete/{id}';

  /**
   * DELETE Mecanicien/Delete/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `supprimerMecanicien()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerMecanicien$Response(params: SupprimerMecanicien$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return supprimerMecanicien(this.http, this.rootUrl, params, context);
  }

  /**
   * DELETE Mecanicien/Delete/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `supprimerMecanicien$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerMecanicien(params: SupprimerMecanicien$Params, context?: HttpContext): Observable<void> {
    return this.supprimerMecanicien$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `getAllMecanicienDesponible()` */
  static readonly GetAllMecanicienDesponiblePath = '/Mecanicien/Desponible';

  /**
   * GET Mecanicien/Desponible.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllMecanicienDesponible()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllMecanicienDesponible$Response(params?: GetAllMecanicienDesponible$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<MecanicienDto>>> {
    return getAllMecanicienDesponible(this.http, this.rootUrl, params, context);
  }

  /**
   * GET Mecanicien/Desponible.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllMecanicienDesponible$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllMecanicienDesponible(params?: GetAllMecanicienDesponible$Params, context?: HttpContext): Observable<Array<MecanicienDto>> {
    return this.getAllMecanicienDesponible$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<MecanicienDto>>): Array<MecanicienDto> => r.body)
    );
  }

  /** Path part for operation `mettreAjourMecanicien()` */
  static readonly MettreAjourMecanicienPath = '/Mecanicien/MettreAjour/{id}';

  /**
   * PUT Mecanicien/MettreAjour/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `mettreAjourMecanicien()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourMecanicien$Response(params: MettreAjourMecanicien$Params, context?: HttpContext): Observable<StrictHttpResponse<MecanicienDto>> {
    return mettreAjourMecanicien(this.http, this.rootUrl, params, context);
  }

  /**
   * PUT Mecanicien/MettreAjour/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `mettreAjourMecanicien$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourMecanicien(params: MettreAjourMecanicien$Params, context?: HttpContext): Observable<MecanicienDto> {
    return this.mettreAjourMecanicien$Response(params, context).pipe(
      map((r: StrictHttpResponse<MecanicienDto>): MecanicienDto => r.body)
    );
  }

  /** Path part for operation `mettreAjourDisponibilite()` */
  static readonly MettreAjourDisponibilitePath = '/Mecanicien/MettreAjour/{id}/Disponibilite';

  /**
   * PUT Mecanicien/MettreAjour/{id}/Disponibilite.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `mettreAjourDisponibilite()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourDisponibilite$Response(params: MettreAjourDisponibilite$Params, context?: HttpContext): Observable<StrictHttpResponse<MecanicienDto>> {
    return mettreAjourDisponibilite(this.http, this.rootUrl, params, context);
  }

  /**
   * PUT Mecanicien/MettreAjour/{id}/Disponibilite.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `mettreAjourDisponibilite$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourDisponibilite(params: MettreAjourDisponibilite$Params, context?: HttpContext): Observable<MecanicienDto> {
    return this.mettreAjourDisponibilite$Response(params, context).pipe(
      map((r: StrictHttpResponse<MecanicienDto>): MecanicienDto => r.body)
    );
  }

  /** Path part for operation `getMecanicienById()` */
  static readonly GetMecanicienByIdPath = '/Mecanicien/{id}';

  /**
   * GET Mecanicien/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getMecanicienById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getMecanicienById$Response(params: GetMecanicienById$Params, context?: HttpContext): Observable<StrictHttpResponse<MecanicienDto>> {
    return getMecanicienById(this.http, this.rootUrl, params, context);
  }

  /**
   * GET Mecanicien/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getMecanicienById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getMecanicienById(params: GetMecanicienById$Params, context?: HttpContext): Observable<MecanicienDto> {
    return this.getMecanicienById$Response(params, context).pipe(
      map((r: StrictHttpResponse<MecanicienDto>): MecanicienDto => r.body)
    );
  }

  /** Path part for operation `getAllPanne()` */
  static readonly GetAllPannePath = '/Panne';

  /**
   * GET Panne.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllPanne()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllPanne$Response(params?: GetAllPanne$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PanneDto>>> {
    return getAllPanne(this.http, this.rootUrl, params, context);
  }

  /**
   * GET Panne.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllPanne$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllPanne(params?: GetAllPanne$Params, context?: HttpContext): Observable<Array<PanneDto>> {
    return this.getAllPanne$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<PanneDto>>): Array<PanneDto> => r.body)
    );
  }

  /** Path part for operation `creerPanne()` */
  static readonly CreerPannePath = '/Panne/Creer';

  /**
   * POST Panne/Creer.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `creerPanne()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerPanne$Response(params: CreerPanne$Params, context?: HttpContext): Observable<StrictHttpResponse<PanneDto>> {
    return creerPanne(this.http, this.rootUrl, params, context);
  }

  /**
   * POST Panne/Creer.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `creerPanne$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerPanne(params: CreerPanne$Params, context?: HttpContext): Observable<PanneDto> {
    return this.creerPanne$Response(params, context).pipe(
      map((r: StrictHttpResponse<PanneDto>): PanneDto => r.body)
    );
  }

  /** Path part for operation `supprimerPanne()` */
  static readonly SupprimerPannePath = '/Panne/Delete/{id}';

  /**
   * DELETE Panne/Delete/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `supprimerPanne()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerPanne$Response(params: SupprimerPanne$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return supprimerPanne(this.http, this.rootUrl, params, context);
  }

  /**
   * DELETE Panne/Delete/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `supprimerPanne$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerPanne(params: SupprimerPanne$Params, context?: HttpContext): Observable<void> {
    return this.supprimerPanne$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `mettreAjourPanne()` */
  static readonly MettreAjourPannePath = '/Panne/MettreAjour/{id}';

  /**
   * PUT Panne/MettreAjour/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `mettreAjourPanne()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourPanne$Response(params: MettreAjourPanne$Params, context?: HttpContext): Observable<StrictHttpResponse<PanneDto>> {
    return mettreAjourPanne(this.http, this.rootUrl, params, context);
  }

  /**
   * PUT Panne/MettreAjour/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `mettreAjourPanne$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourPanne(params: MettreAjourPanne$Params, context?: HttpContext): Observable<PanneDto> {
    return this.mettreAjourPanne$Response(params, context).pipe(
      map((r: StrictHttpResponse<PanneDto>): PanneDto => r.body)
    );
  }

  /** Path part for operation `getPanneById()` */
  static readonly GetPanneByIdPath = '/Panne/{id}';

  /**
   * GET Panne/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getPanneById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPanneById$Response(params: GetPanneById$Params, context?: HttpContext): Observable<StrictHttpResponse<PanneDto>> {
    return getPanneById(this.http, this.rootUrl, params, context);
  }

  /**
   * GET Panne/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getPanneById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPanneById(params: GetPanneById$Params, context?: HttpContext): Observable<PanneDto> {
    return this.getPanneById$Response(params, context).pipe(
      map((r: StrictHttpResponse<PanneDto>): PanneDto => r.body)
    );
  }

  /** Path part for operation `getAllVehicule()` */
  static readonly GetAllVehiculePath = '/Vehicule';

  /**
   * GET Vehicule.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllVehicule()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllVehicule$Response(params?: GetAllVehicule$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<VehiculeDto>>> {
    return getAllVehicule(this.http, this.rootUrl, params, context);
  }

  /**
   * GET Vehicule.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllVehicule$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllVehicule(params?: GetAllVehicule$Params, context?: HttpContext): Observable<Array<VehiculeDto>> {
    return this.getAllVehicule$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<VehiculeDto>>): Array<VehiculeDto> => r.body)
    );
  }

  /** Path part for operation `creerVehicule()` */
  static readonly CreerVehiculePath = '/Vehicule/Creer';

  /**
   * POST Vehicule/Creer.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `creerVehicule()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerVehicule$Response(params: CreerVehicule$Params, context?: HttpContext): Observable<StrictHttpResponse<VehiculeDto>> {
    return creerVehicule(this.http, this.rootUrl, params, context);
  }

  /**
   * POST Vehicule/Creer.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `creerVehicule$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerVehicule(params: CreerVehicule$Params, context?: HttpContext): Observable<VehiculeDto> {
    return this.creerVehicule$Response(params, context).pipe(
      map((r: StrictHttpResponse<VehiculeDto>): VehiculeDto => r.body)
    );
  }

  /** Path part for operation `supprimerVehicule()` */
  static readonly SupprimerVehiculePath = '/Vehicule/Delete/{id}';

  /**
   * DELETE Vehicule/Delete/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `supprimerVehicule()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerVehicule$Response(params: SupprimerVehicule$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return supprimerVehicule(this.http, this.rootUrl, params, context);
  }

  /**
   * DELETE Vehicule/Delete/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `supprimerVehicule$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerVehicule(params: SupprimerVehicule$Params, context?: HttpContext): Observable<void> {
    return this.supprimerVehicule$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `mettreAjourVehicule()` */
  static readonly MettreAjourVehiculePath = '/Vehicule/MettreAjour/{id}';

  /**
   * PUT Vehicule/MettreAjour/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `mettreAjourVehicule()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourVehicule$Response(params: MettreAjourVehicule$Params, context?: HttpContext): Observable<StrictHttpResponse<VehiculeDto>> {
    return mettreAjourVehicule(this.http, this.rootUrl, params, context);
  }

  /**
   * PUT Vehicule/MettreAjour/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `mettreAjourVehicule$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourVehicule(params: MettreAjourVehicule$Params, context?: HttpContext): Observable<VehiculeDto> {
    return this.mettreAjourVehicule$Response(params, context).pipe(
      map((r: StrictHttpResponse<VehiculeDto>): VehiculeDto => r.body)
    );
  }

  /** Path part for operation `getVehiculeById()` */
  static readonly GetVehiculeByIdPath = '/Vehicule/{id}';

  /**
   * GET Vehicule/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getVehiculeById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getVehiculeById$Response(params: GetVehiculeById$Params, context?: HttpContext): Observable<StrictHttpResponse<VehiculeDto>> {
    return getVehiculeById(this.http, this.rootUrl, params, context);
  }

  /**
   * GET Vehicule/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getVehiculeById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getVehiculeById(params: GetVehiculeById$Params, context?: HttpContext): Observable<VehiculeDto> {
    return this.getVehiculeById$Response(params, context).pipe(
      map((r: StrictHttpResponse<VehiculeDto>): VehiculeDto => r.body)
    );
  }

  /** Path part for operation `getAllParticipation()` */
  static readonly GetAllParticipationPath = '/Participation';

  /**
   * GET Participation.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllParticipation()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllParticipation$Response(params?: GetAllParticipation$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<ParticipationDto>>> {
    return getAllParticipation(this.http, this.rootUrl, params, context);
  }

  /**
   * GET Participation.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllParticipation$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllParticipation(params?: GetAllParticipation$Params, context?: HttpContext): Observable<Array<ParticipationDto>> {
    return this.getAllParticipation$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<ParticipationDto>>): Array<ParticipationDto> => r.body)
    );
  }

  /** Path part for operation `creerParticipation()` */
  static readonly CreerParticipationPath = '/Participation/Creer';

  /**
   * POST Participation/Creer.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `creerParticipation()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerParticipation$Response(params: CreerParticipation$Params, context?: HttpContext): Observable<StrictHttpResponse<ParticipationDto>> {
    return creerParticipation(this.http, this.rootUrl, params, context);
  }

  /**
   * POST Participation/Creer.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `creerParticipation$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerParticipation(params: CreerParticipation$Params, context?: HttpContext): Observable<ParticipationDto> {
    return this.creerParticipation$Response(params, context).pipe(
      map((r: StrictHttpResponse<ParticipationDto>): ParticipationDto => r.body)
    );
  }

  /** Path part for operation `supprimerParticipation()` */
  static readonly SupprimerParticipationPath = '/Participation/Delete/{id}';

  /**
   * DELETE Participation/Delete/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `supprimerParticipation()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerParticipation$Response(params: SupprimerParticipation$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return supprimerParticipation(this.http, this.rootUrl, params, context);
  }

  /**
   * DELETE Participation/Delete/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `supprimerParticipation$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  supprimerParticipation(params: SupprimerParticipation$Params, context?: HttpContext): Observable<void> {
    return this.supprimerParticipation$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `mettreAjourParticipation()` */
  static readonly MettreAjourParticipationPath = '/Participation/MettreAjour/{id}';

  /**
   * PUT Participation/MettreAjour/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `mettreAjourParticipation()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourParticipation$Response(params: MettreAjourParticipation$Params, context?: HttpContext): Observable<StrictHttpResponse<ParticipationDto>> {
    return mettreAjourParticipation(this.http, this.rootUrl, params, context);
  }

  /**
   * PUT Participation/MettreAjour/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `mettreAjourParticipation$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mettreAjourParticipation(params: MettreAjourParticipation$Params, context?: HttpContext): Observable<ParticipationDto> {
    return this.mettreAjourParticipation$Response(params, context).pipe(
      map((r: StrictHttpResponse<ParticipationDto>): ParticipationDto => r.body)
    );
  }

  /** Path part for operation `getParticipationById()` */
  static readonly GetParticipationByIdPath = '/Participation/{id}';

  /**
   * GET Participation/{id}.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getParticipationById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getParticipationById$Response(params: GetParticipationById$Params, context?: HttpContext): Observable<StrictHttpResponse<ParticipationDto>> {
    return getParticipationById(this.http, this.rootUrl, params, context);
  }

  /**
   * GET Participation/{id}.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getParticipationById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getParticipationById(params: GetParticipationById$Params, context?: HttpContext): Observable<ParticipationDto> {
    return this.getParticipationById$Response(params, context).pipe(
      map((r: StrictHttpResponse<ParticipationDto>): ParticipationDto => r.body)
    );
  }

}
