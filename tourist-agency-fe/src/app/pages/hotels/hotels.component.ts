import {HttpErrorResponse} from '@angular/common/http';
import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {DomSanitizer} from '@angular/platform-browser';
import {MatSnackBar} from '@angular/material/snack-bar';
import {Router} from '@angular/router';
import {Hotel, IDestination, IHotel} from 'src/app/common/components/model';
import {DestinationService} from 'src/app/services/destination/destination.service';
import {HotelService} from 'src/app/services/hotel/hotel.service';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent implements OnInit {

  public hotels: IHotel[];
  public destinations: IDestination[];
  public editHotel: IHotel;
  public deleteHotel: IHotel;
  public hotel: Hotel;

  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;

  constructor(private hotelService: HotelService,
              private destinationService: DestinationService,
              private router: Router,
              private snackBar: MatSnackBar,
              private domSanitizer: DomSanitizer) {
  }

  ngOnInit(): void {
    this.getHotels();
    this.getDestinations();
  }

  public getDestinations(): void {
    this.destinationService.getDestinations().subscribe(
      (response: IDestination[]) => {
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
      (response: IHotel[]) => {
        this.hotels = response;
        console.log(this.hotels);
        this.loadImages();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddHotel(addForm: NgForm): void {

    console.log(this.selectedFile);
    const hotel = new FormData();
    hotel.append('imageFile', this.selectedFile, this.selectedFile.name);
    hotel.append('name', addForm.value.name);
    hotel.append('address', addForm.value.address);
    hotel.append('rating', addForm.value.rating);
    hotel.append('destination_name', addForm.value.destination.name);

    hotel.forEach((value, key) => {
      console.log(key + ' ' + value);
    });

    document.getElementById('add-hotel-form').click();
    this.hotelService.addHotel(hotel).subscribe(
      (response: IHotel) => {
        console.log(response);
        this.getHotels();
        this.openSnackBar('Hotel with id: ' + response.id + ' is successfully added!');
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
        this.openSnackBar(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onUpdateHotel(hotel: IHotel): void {
    console.log(hotel);

    this.hotelService.updateHotel(hotel).subscribe(
      (response: IHotel) => {
        console.log(response);
        this.getHotels();
        this.openSnackBar('Hotel with id:  ' + response.id + ' is successfully updated!');
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public hotelDetails(id: number) {
    this.router.navigate(['details', id]);
  }

  public onOpenModal(hotel: IHotel, mode: string): void {
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
    const results: IHotel[] = [];
    for (const hotel of this.hotels) {
      if ((hotel.name.toLowerCase().indexOf(key.toLowerCase()) !== -1)
        || (hotel.address.toLowerCase().indexOf(key.toLowerCase()) !== -1)
        || (hotel.destination.name.toLowerCase().indexOf(key.toLowerCase()) !== -1)
        || (hotel.destination.state.name.toLowerCase().indexOf(key.toLowerCase()) !== -1)) {
        results.push(hotel);
      }
    }
    this.hotels = results;
    if (results.length === 0 || !key) {
      this.getHotels();
    }
  }

  // Gets called when the user selects an image
  public onFileChanged(event) {
    this.selectedFile = event.target.files[0];
  }

  public openSnackBar(message: String) {
    this.snackBar.open(message.toString(), '',
      {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'center'
      });
  }

  private loadImages(): void {
    for (const hotel of this.hotels) {
      const imageNameParts = hotel.imageName.split('.');
      const imageExtension = imageNameParts[imageNameParts.length - 1];
      hotel.image = 'data:image/' + imageExtension + ';base64,' + hotel.image;
      this.domSanitizer.bypassSecurityTrustResourceUrl(hotel.image);
    }
  }
}
