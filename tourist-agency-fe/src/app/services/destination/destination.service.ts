import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Destination } from 'src/app/common/components/model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DestinationService {

  constructor(private httpClient: HttpClient) { }

  public getDestinations(): Observable<Destination[]> {
    return this.httpClient.get<Destination[]>(`${environment.baseHttpURL}/destination`);
  }

}
