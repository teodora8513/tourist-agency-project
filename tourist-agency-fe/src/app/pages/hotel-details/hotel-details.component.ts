import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, NgForm } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Hotel, Room, RoomIdentity, RoomType } from 'src/app/common/components/model';
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
  roomType = RoomType;
  enumKeys=[];
  room: Room;
  roomIdentity: RoomIdentity={};
  public editRoom: Room;
  public deleteRoom: Room;

  constructor(private route: ActivatedRoute,private router: Router,
              private hotelService: HotelService,
              private roomService: RoomService,
              private fb: FormBuilder,
              private _snackBar: MatSnackBar)
              {
                this.enumKeys=Object.keys(this.roomType);
              }

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

  public onAddRoom(addForm: NgForm): void {

    this.room = addForm.value;
    this.roomIdentity.hotel_id = this.id;
    this.roomIdentity.room_number = addForm.value.room_number;
    this.room.id = this.roomIdentity;
    this.room.hotel = this.hotel;
    this.room.available = true;
    console.log(this.room);

    document.getElementById('add-room-form').click();
    this.roomService.addRoom(this.room).subscribe(
      (response: Room) => {
        console.log(response);
        this.getRooms();
        this.openSnackBar("Room " + response.id.room_number + " is successfully added!");
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );

    addForm.reset();
  }

  public onDeleteRoom(roomId: RoomIdentity): void {

    console.log(roomId);
    this.roomService.deleteRoom(roomId).subscribe(
      (response: String) => {
        console.log(response);
        this.getRooms();
        this.openSnackBar(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onUpdateRoom(room: Room, room_number: string): void {

    this.roomIdentity.hotel_id = this.id;
    this.roomIdentity.room_number = room_number;
    room.id = this.roomIdentity;
    room.hotel = this.hotel;
    room.available = true;

    console.log(room);

    this.roomService.updateRoom(room).subscribe(
      (response: Room) => {
        console.log(response);
        this.getRooms();
        this.openSnackBar("Room " + room.id.room_number + " is successfully updated!");
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(room: Room, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if (mode === 'edit') {
      this.editRoom = room;
      button.setAttribute('data-target', '#updateRoomModal');
    }
    if (mode === 'delete') {
      this.deleteRoom = room;
      button.setAttribute('data-target', '#deleteRoomModal');
    }
    container.appendChild(button);
    button.click();
  }

  public openSnackBar(message: String){
    this._snackBar.open(message.toString(), '',
    {
      duration : 3000,
      verticalPosition: 'top',
      horizontalPosition: 'center'
    });
  }

}
