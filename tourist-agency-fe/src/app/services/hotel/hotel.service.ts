import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  public addHotel(hotel: FormData): Observable<Hotel> {
    const HttpUploadOptions = {
      headers: new HttpHeaders({ "Content-Type": "multipart/form-data" })
    }
    return this.httpClient.post<Hotel>(`${environment.baseHttpURL}/hotel`, hotel);
  }

  public updateHotel(hotel: Hotel): Observable<Hotel> {
    return this.httpClient.put<Hotel>(`${environment.baseHttpURL}/hotel/${hotel.id}`, hotel);
  }

  public deleteHotel(hotelId: number): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.httpClient.delete<any>(`${environment.baseHttpURL}/hotel/${hotelId}`, { headers, responseType: 'text' as 'json'});
  }

  public getHotelById(hotelId: number): Observable<Hotel> {
    return this.httpClient.get<Hotel>(`${environment.baseHttpURL}/hotel/${hotelId}`);
  }


}
