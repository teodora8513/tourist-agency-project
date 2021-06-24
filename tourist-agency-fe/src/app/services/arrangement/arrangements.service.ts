import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Arrangement } from 'src/app/common/components/model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ArrangementsService {

  constructor(private httpClient: HttpClient) { }

gettAllArrangements(){
  return this.httpClient.get<Arrangement[]>(`${environment.baseHttpURL}/reservation`);
}

}
