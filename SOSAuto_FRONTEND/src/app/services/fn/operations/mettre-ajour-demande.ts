/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { DemandeDepannageDto } from '../../models/demande-depannage-dto';

export interface MettreAjourDemande$Params {
  id: number;
      body: DemandeDepannageDto
}

export function mettreAjourDemande(http: HttpClient, rootUrl: string, params: MettreAjourDemande$Params, context?: HttpContext): Observable<StrictHttpResponse<DemandeDepannageDto>> {
  const rb = new RequestBuilder(rootUrl, mettreAjourDemande.PATH, 'put');
  if (params) {
    rb.path('id', params.id, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<DemandeDepannageDto>;
    })
  );
}

mettreAjourDemande.PATH = '/autoadmin/DemandeDepannage/MettreAjour/{id}';
