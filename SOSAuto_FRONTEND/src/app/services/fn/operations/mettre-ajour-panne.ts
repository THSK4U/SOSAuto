/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { PanneDto } from '../../models/panne-dto';

export interface MettreAjourPanne$Params {
  id: number;
      body: PanneDto
}

export function mettreAjourPanne(http: HttpClient, rootUrl: string, params: MettreAjourPanne$Params, context?: HttpContext): Observable<StrictHttpResponse<PanneDto>> {
  const rb = new RequestBuilder(rootUrl, mettreAjourPanne.PATH, 'put');
  if (params) {
    rb.path('id', params.id, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<PanneDto>;
    })
  );
}

mettreAjourPanne.PATH = '/admin/Panne/MettreAjour/{id}';
