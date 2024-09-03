/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { VehiculeDto } from '../../models/vehicule-dto';

export interface CreerVehicule$Params {
      body: VehiculeDto
}

export function creerVehicule(http: HttpClient, rootUrl: string, params: CreerVehicule$Params, context?: HttpContext): Observable<StrictHttpResponse<VehiculeDto>> {
  const rb = new RequestBuilder(rootUrl, creerVehicule.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<VehiculeDto>;
    })
  );
}

creerVehicule.PATH = '/Vehicule/Creer';
