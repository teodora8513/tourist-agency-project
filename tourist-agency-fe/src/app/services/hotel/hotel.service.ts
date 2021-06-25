import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from 'src/app/common/components/model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private httpClient: HttpClient) { }

  public getHotels(): Observable<Hotel[]> {
    return this.httpClient.get<Hotel[]>(`${environment.baseHttpURL}/hotel`);
  }

  public addHotel(hotel: Hotel): Observable<Hotel> {
    return this.httpClient.post<Hotel>(`${environment.baseHttpURL}/hotel`, hotel);
  }

  public updateHotel(hotel: Hotel): Observable<Hotel> {
    return this.httpClient.put<Hotel>(`${environment.baseHttpURL}/hotel`, hotel);
  }

  public deleteHotel(hotelId: number): Observable<any> {
    return this.httpClient.delete<void>(`${environment.baseHttpURL}/hotel/${hotelId}`);
  }
}
