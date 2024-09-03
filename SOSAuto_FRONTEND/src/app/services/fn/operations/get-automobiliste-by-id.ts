/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { AutomobilisteDto } from '../../models/automobiliste-dto';

export interface GetAutomobilisteById$Params {
  id: number;
}

export function getAutomobilisteById(http: HttpClient, rootUrl: string, params: GetAutomobilisteById$Params, context?: HttpContext): Observable<StrictHttpResponse<AutomobilisteDto>> {
  const rb = new RequestBuilder(rootUrl, getAutomobilisteById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<AutomobilisteDto>;
    })
  );
}

getAutomobilisteById.PATH = '/Automobiliste/{id}';
