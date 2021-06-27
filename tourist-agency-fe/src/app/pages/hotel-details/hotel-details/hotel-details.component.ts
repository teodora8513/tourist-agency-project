import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hotel } from 'src/app/common/components/model';
import { HotelService } from 'src/app/services/hotel/hotel.service';

@Component({
  selector: 'app-hotel-details',
  templateUrl: './hotel-details.component.html',
  styleUrls: ['./hotel-details.component.css']
})
export class HotelDetailsComponent implements OnInit {

  id: number;
  hotel: Hotel;

  constructor(private route: ActivatedRoute,private router: Router,
              private hotelService: HotelService) { }

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
  }

  public back(){
    this.router.navigate(['hotels']);
  }

}
