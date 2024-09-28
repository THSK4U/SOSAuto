/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { ParticipationDto } from '../../models/participation-dto';

export interface RejectParticipation$Params {
  participationId?: number;
}

export function rejectParticipation(http: HttpClient, rootUrl: string, params: RejectParticipation$Params, context?: HttpContext): Observable<StrictHttpResponse<ParticipationDto>> {
  const rb = new RequestBuilder(rootUrl, rejectParticipation.PATH, 'post');
  if (params) {
    rb.path('participationId', params.participationId, {});
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

rejectParticipation.PATH = '/mechanic/reject/{participationId}';
