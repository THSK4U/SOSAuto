/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { AdministrateurDto } from '../../models/administrateur-dto';
import { AuthResponse } from '../../models/auth-response';

export interface CreerAdministrateur$Params {
      body: AdministrateurDto
}

export function creerAdministrateur(http: HttpClient, rootUrl: string, params: CreerAdministrateur$Params, context?: HttpContext): Observable<StrictHttpResponse<AuthResponse>> {
  const rb = new RequestBuilder(rootUrl, creerAdministrateur.PATH, 'post');
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

creerAdministrateur.PATH = '/admin/Administrateur/create';
