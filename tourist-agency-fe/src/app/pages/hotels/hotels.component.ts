import { HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Destination, Hotel } from 'src/app/common/components/model';
import { DestinationService } from 'src/app/services/destination/destination.service';
import { HotelService } from 'src/app/services/hotel/hotel.service';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent implements OnInit {

  public hotels: Hotel[];
  public destinations: Destination[];
  public editHotel: Hotel;
  public deleteHotel: Hotel;

  constructor(private hotelService: HotelService, private destinationService: DestinationService){}

  ngOnInit() {
    this.getHotels();
    this.getDestinations();
  }

  public getRating(hotel: Hotel): number{
    return hotel.rating;
  }

  public getDestinations(): void {
    this.destinationService.getDestinations().subscribe(
      (response: Destination[]) => {
        this.destinations = response;
        console.log(this.destinations);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getHotels(): void {
    this.hotelService.getHotels().subscribe(
      (response: Hotel[]) => {
        this.hotels = response;
        console.log(this.hotels);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddHotel(addForm: NgForm): void {
    document.getElementById('add-hotel-form').click();
    this.hotelService.addHotel(addForm.value).subscribe(
      (response: Hotel) => {
        console.log(response);
        this.getHotels();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );

    addForm.reset();
  }

  public onDeleteHotel(hotelId: number): void {

    this.hotelService.deleteHotel(hotelId).subscribe(
      (response: String) => {
        console.log(response);
        this.getHotels();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onUpdateHotel(hotel: Hotel): void {
    console.log(hotel);
    this.hotelService.updateHotel(hotel).subscribe(
      (response: Hotel) => {
        console.log(response);
        this.getHotels();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(hotel: Hotel, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if (mode === 'edit') {
      this.editHotel = hotel;
      button.setAttribute('data-target', '#updateHotelModal');
    }
    if (mode === 'delete') {
      this.deleteHotel = hotel;
      button.setAttribute('data-target', '#deleteHotelModal');
    }
    container.appendChild(button);
    button.click();
  }

  public searchHotels(key: string): void {
    console.log(key);
    const results: Hotel[] = [];
    for (const hotel of this.hotels) {
      if ((hotel.name.toLowerCase().indexOf(key.toLowerCase()) !== -1)
      || (hotel.address.toLowerCase().indexOf(key.toLowerCase()) !== -1)
      || (hotel.destination.name.toLowerCase().indexOf(key.toLowerCase()) !== -1)
      || (hotel.destination.state.name.toLowerCase().indexOf(key.toLowerCase()) !== -1))
      {
        results.push(hotel);
      }
    }
    this.hotels = results;
    if (results.length === 0 || !key) {
      this.getHotels();
    }
  }
}
