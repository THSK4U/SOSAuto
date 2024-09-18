/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { ParticipationDto } from '../../models/participation-dto';

export interface AnnulerParticipation$Params {
  id: number;
}

export function annulerParticipation(http: HttpClient, rootUrl: string, params: AnnulerParticipation$Params, context?: HttpContext): Observable<StrictHttpResponse<ParticipationDto>> {
  const rb = new RequestBuilder(rootUrl, annulerParticipation.PATH, 'put');
  if (params) {
    rb.path('id', params.id, {});
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

annulerParticipation.PATH = '/mechadmin/Participation/{id}/Annuler';
