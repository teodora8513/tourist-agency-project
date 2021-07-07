import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {IArrangement} from 'src/app/common/components/model';
import {environment} from 'src/environments/environment';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArrangementsService {

  constructor(private httpClient: HttpClient) {
  }

  public getAllArrangements(): Observable<IArrangement[]> {
    return this.httpClient.get<IArrangement[]>(`${environment.baseHttpURL}/reservation`);
  }

  public createArrangement(arrangement: IArrangement): Observable<any> {
    return this.httpClient.post(`${environment.baseHttpURL}/reservation`, arrangement);
  }

}
