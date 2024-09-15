/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { AutomobilisteDto } from '../../models/automobiliste-dto';

export interface MettreAjourAutomobiliste$Params {
  id: number;
      body: AutomobilisteDto
}

export function mettreAjourAutomobiliste(http: HttpClient, rootUrl: string, params: MettreAjourAutomobiliste$Params, context?: HttpContext): Observable<StrictHttpResponse<AutomobilisteDto>> {
  const rb = new RequestBuilder(rootUrl, mettreAjourAutomobiliste.PATH, 'put');
  if (params) {
    rb.path('id', params.id, {});
    rb.body(params.body, 'application/json');
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

mettreAjourAutomobiliste.PATH = '/autoadmin/Automobiliste/MettreAjour/{id}';
