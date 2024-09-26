/* tslint:disable */
/* eslint-disable */
/* Code generated by ng-openapi-gen DO NOT EDIT. */

import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { ParticipationDto } from '../../models/participation-dto';

export interface GetAllParticipationByIdAutomobilist$Params {
  id: number;
}

export function getAllParticipationByIdAutomobilist(http: HttpClient, rootUrl: string, params: GetAllParticipationByIdAutomobilist$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<ParticipationDto>>> {
  const rb = new RequestBuilder(rootUrl, getAllParticipationByIdAutomobilist.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<ParticipationDto>>;
    })
  );
}

getAllParticipationByIdAutomobilist.PATH = '/mechadmin/Participation/Automobiliste/{id}';