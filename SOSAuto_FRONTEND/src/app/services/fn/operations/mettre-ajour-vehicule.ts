/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { VehiculeDto } from '../../models/vehicule-dto';

export interface MettreAjourVehicule$Params {
  id: number;
      body: VehiculeDto
}

export function mettreAjourVehicule(http: HttpClient, rootUrl: string, params: MettreAjourVehicule$Params, context?: HttpContext): Observable<StrictHttpResponse<VehiculeDto>> {
  const rb = new RequestBuilder(rootUrl, mettreAjourVehicule.PATH, 'put');
  if (params) {
    rb.path('id', params.id, {});
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

mettreAjourVehicule.PATH = '/Vehicule/MettreAjour/{id}';
