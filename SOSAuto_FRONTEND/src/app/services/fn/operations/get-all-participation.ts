/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { ParticipationDto } from '../../models/participation-dto';

export interface GetAllParticipation$Params {
}

export function getAllParticipation(http: HttpClient, rootUrl: string, params?: GetAllParticipation$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<ParticipationDto>>> {
  const rb = new RequestBuilder(rootUrl, getAllParticipation.PATH, 'get');
  if (params) {
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

getAllParticipation.PATH = '/Participation';
