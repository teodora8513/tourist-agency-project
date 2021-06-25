import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Hotel } from 'src/app/common/components/model';
import { HotelService } from 'src/app/services/hotel/hotel.service';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent implements OnInit {

  public hotels: Hotel[];

  constructor(private hotelService: HotelService){}

  ngOnInit() {
    this.getHotels();
  }

  public getRating(hotel: Hotel): number{
    return hotel.rating;
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
}
