/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { VehiculeDto } from '../../models/vehicule-dto';

export interface GetAllVehicule$Params {
}

export function getAllVehicule(http: HttpClient, rootUrl: string, params?: GetAllVehicule$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<VehiculeDto>>> {
  const rb = new RequestBuilder(rootUrl, getAllVehicule.PATH, 'get');
  if (params) {
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<VehiculeDto>>;
    })
  );
}

getAllVehicule.PATH = '/admin/Vehicule';
