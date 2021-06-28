import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Room } from 'src/app/common/components/model';
import { environment } from 'src/environments/environment';
import { Hotel } from 'src/app/common/components/model';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private httpClient: HttpClient) { }

  public getRoomsByHotelId(hotelId: number): Observable<Room[]> {
    return this.httpClient.get<Room[]>(`${environment.baseHttpURL}/room/hotel/${hotelId}`);
  }
}
