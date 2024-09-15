/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { MecanicienDto } from '../../models/mecanicien-dto';

export interface MettreAjourMecanicien$Params {
  id: number;
      body: MecanicienDto
}

export function mettreAjourMecanicien(http: HttpClient, rootUrl: string, params: MettreAjourMecanicien$Params, context?: HttpContext): Observable<StrictHttpResponse<MecanicienDto>> {
  const rb = new RequestBuilder(rootUrl, mettreAjourMecanicien.PATH, 'put');
  if (params) {
    rb.path('id', params.id, {});
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

mettreAjourMecanicien.PATH = '/mechadmin/Mecanicien/MettreAjour/{id}';
