/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { ParticipationDto } from '../../models/participation-dto';

export interface GetAllParticipationByIdMecanicien$Params {
  id: number;
}

export function getAllParticipationByIdMecanicien(http: HttpClient, rootUrl: string, params: GetAllParticipationByIdMecanicien$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<ParticipationDto>>> {
  const rb = new RequestBuilder(rootUrl, getAllParticipationByIdMecanicien.PATH, 'get');
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

getAllParticipationByIdMecanicien.PATH = '/mechadmin/Participation/Mecanicien/{id}';
