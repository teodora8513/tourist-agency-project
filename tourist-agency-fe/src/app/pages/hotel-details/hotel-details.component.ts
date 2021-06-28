import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hotel, Room } from 'src/app/common/components/model';
import { HotelService } from 'src/app/services/hotel/hotel.service';
import { RoomService } from 'src/app/services/room/room.service';

@Component({
  selector: 'app-hotel-details',
  templateUrl: './hotel-details.component.html',
  styleUrls: ['./hotel-details.component.css']
})
export class HotelDetailsComponent implements OnInit {
  id: number;
  hotel: Hotel;
  rooms: Room[];

  constructor(private route: ActivatedRoute,private router: Router,
              private hotelService: HotelService,
              private roomService: RoomService) { }

  ngOnInit(): void {
    //this.hotel = new Hotel();

    this.id = this.route.snapshot.params['id'];

    this.hotelService.getHotelById(this.id)
      .subscribe(
        (response: Hotel) => {
          console.log(response);
          this.hotel = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );

      this.getRooms();
  }

  public back(){
    this.router.navigate(['hotels']);
  }

  public manageRooms(){
    this.router.navigate(['rooms']);
  }

  public getRooms(): void {
    this.roomService.getRoomsByHotelId(this.id).subscribe(
      (response: Room[]) => {
        this.rooms = response;
        console.log(this.rooms);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
