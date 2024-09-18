/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';


export interface SupprimerParticipationByDemande$Params {
  Demandid: number;
  Mecanicienid: number;
}

export function supprimerParticipationByDemande(http: HttpClient, rootUrl: string, params: SupprimerParticipationByDemande$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
  const rb = new RequestBuilder(rootUrl, supprimerParticipationByDemande.PATH, 'delete');
  if (params) {
    rb.path('Demandid', params.Demandid, {});
    rb.path('Mecanicienid', params.Mecanicienid, {});
  }

  return http.request(
    rb.build({ responseType: 'text', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return (r as HttpResponse<any>).clone({ body: undefined }) as StrictHttpResponse<void>;
    })
  );
}

supprimerParticipationByDemande.PATH = '/mechadmin/Participation/DeleteByDemande/{Demandid}/Mecanicien/{Mecanicienid}';
