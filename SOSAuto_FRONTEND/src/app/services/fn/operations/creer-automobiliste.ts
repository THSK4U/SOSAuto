/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { AuthResponse } from '../../models/auth-response';
import { AutomobilisteDto } from '../../models/automobiliste-dto';

export interface CreerAutomobiliste$Params {
      body: AutomobilisteDto
}

export function creerAutomobiliste(http: HttpClient, rootUrl: string, params: CreerAutomobiliste$Params, context?: HttpContext): Observable<StrictHttpResponse<AuthResponse>> {
  const rb = new RequestBuilder(rootUrl, creerAutomobiliste.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<AuthResponse>;
    })
  );
}

creerAutomobiliste.PATH = '/All/Automobiliste/Creer';
