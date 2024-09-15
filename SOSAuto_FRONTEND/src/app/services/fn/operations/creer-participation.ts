/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { ParticipationDto } from '../../models/participation-dto';

export interface CreerParticipation$Params {
      body: ParticipationDto
}

export function creerParticipation(http: HttpClient, rootUrl: string, params: CreerParticipation$Params, context?: HttpContext): Observable<StrictHttpResponse<ParticipationDto>> {
  const rb = new RequestBuilder(rootUrl, creerParticipation.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<ParticipationDto>;
    })
  );
}

creerParticipation.PATH = '/mechanic/Participation/Creer';
