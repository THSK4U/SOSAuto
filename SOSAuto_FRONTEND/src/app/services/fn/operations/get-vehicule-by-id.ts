/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { VehiculeDto } from '../../models/vehicule-dto';

export interface GetVehiculeById$Params {
  id: number;
}

export function getVehiculeById(http: HttpClient, rootUrl: string, params: GetVehiculeById$Params, context?: HttpContext): Observable<StrictHttpResponse<VehiculeDto>> {
  const rb = new RequestBuilder(rootUrl, getVehiculeById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
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

getVehiculeById.PATH = '/autoadmin/Vehicule/{id}';
