/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { MecanicienDto } from '../../models/mecanicien-dto';

export interface CreerMecanicien$Params {
      body: MecanicienDto
}

export function creerMecanicien(http: HttpClient, rootUrl: string, params: CreerMecanicien$Params, context?: HttpContext): Observable<StrictHttpResponse<MecanicienDto>> {
  const rb = new RequestBuilder(rootUrl, creerMecanicien.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<MecanicienDto>;
    })
  );
}

creerMecanicien.PATH = '/Mecanicien/Creer';
