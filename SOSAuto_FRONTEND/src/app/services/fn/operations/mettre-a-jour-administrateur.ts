/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { AdministrateurDto } from '../../models/administrateur-dto';

export interface MettreAJourAdministrateur$Params {
  id: number;
      body: AdministrateurDto
}

export function mettreAJourAdministrateur(http: HttpClient, rootUrl: string, params: MettreAJourAdministrateur$Params, context?: HttpContext): Observable<StrictHttpResponse<AdministrateurDto>> {
  const rb = new RequestBuilder(rootUrl, mettreAJourAdministrateur.PATH, 'put');
  if (params) {
    rb.path('id', params.id, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<AdministrateurDto>;
    })
  );
}

mettreAJourAdministrateur.PATH = '/admin/Administrateur/update/{id}';
