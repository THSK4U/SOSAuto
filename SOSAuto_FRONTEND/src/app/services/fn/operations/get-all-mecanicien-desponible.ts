/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { MecanicienDto } from '../../models/mecanicien-dto';

export interface GetAllMecanicienDesponible$Params {
}

export function getAllMecanicienDesponible(http: HttpClient, rootUrl: string, params?: GetAllMecanicienDesponible$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<MecanicienDto>>> {
  const rb = new RequestBuilder(rootUrl, getAllMecanicienDesponible.PATH, 'get');
  if (params) {
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<MecanicienDto>>;
    })
  );
}

getAllMecanicienDesponible.PATH = '/autoadmin/Mecanicien/Desponible';
