import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmailService {
  constructor(private httpClient: HttpClient) { }

  public send(email: string): Observable<any> {
    console.log(email);

    return this.httpClient.post(`${environment.baseHttpURL}/email/send`,email);

  }
}
