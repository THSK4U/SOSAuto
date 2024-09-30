/* tslint:disable */
/* eslint-disable */
/* Code generated by ng-openapi-gen DO NOT EDIT. */

import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { DemandeDepannageDto } from '../../models/demande-depannage-dto';

export interface GetAllDemandeByAutomobiliste$Params {
  id: number;
}

export function getAllDemandeByAutomobiliste(http: HttpClient, rootUrl: string, params: GetAllDemandeByAutomobiliste$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<DemandeDepannageDto>>> {
  const rb = new RequestBuilder(rootUrl, getAllDemandeByAutomobiliste.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<DemandeDepannageDto>>;
    })
  );
}

getAllDemandeByAutomobiliste.PATH = '/automobiliste/DemandeDepannage/Automobiliste/{id}';
