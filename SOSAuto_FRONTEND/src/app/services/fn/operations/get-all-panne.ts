/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { PanneDto } from '../../models/panne-dto';

export interface GetAllPanne$Params {
}

export function getAllPanne(http: HttpClient, rootUrl: string, params?: GetAllPanne$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PanneDto>>> {
  const rb = new RequestBuilder(rootUrl, getAllPanne.PATH, 'get');
  if (params) {
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<PanneDto>>;
    })
  );
}

getAllPanne.PATH = '/autoadmin/Panne';
