/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { AutomobilisteDto } from '../../models/automobiliste-dto';

export interface GetAllAutomobiliste$Params {
}

export function getAllAutomobiliste(http: HttpClient, rootUrl: string, params?: GetAllAutomobiliste$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<AutomobilisteDto>>> {
  const rb = new RequestBuilder(rootUrl, getAllAutomobiliste.PATH, 'get');
  if (params) {
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<AutomobilisteDto>>;
    })
  );
}

getAllAutomobiliste.PATH = '/Automobiliste';
