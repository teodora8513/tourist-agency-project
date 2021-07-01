import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  public addRoom(room: Room): Observable<Room> {
    return this.httpClient.post<Room>(`${environment.baseHttpURL}/room`, room);
  }

  public updateRoom(room: Room): Observable<Room> {
    return this.httpClient.put<Room>(`${environment.baseHttpURL}/room/${room.id.hotel_id, room.id.room_number}`, room);
  }

  public deleteRoom(roomId: number): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.httpClient.delete<any>(`${environment.baseHttpURL}/room/${roomId}`, { headers, responseType: 'text' as 'json'});
  }
}
