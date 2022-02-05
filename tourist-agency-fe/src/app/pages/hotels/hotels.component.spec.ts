import { TestBed } from '@angular/core/testing';
import {HttpClientModule} from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { RouterTestingModule } from '@angular/router/testing';
import { HotelsComponent } from './hotels.component';
import { HotelService } from 'src/app/services/hotel/hotel.service';
import { DestinationService } from 'src/app/services/destination/destination.service';
import { DomSanitizer } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

describe('Hotels', () => {

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule,FormsModule, MatSnackBarModule, RouterTestingModule],
      declarations: [
        HotelsComponent,
      ],
      providers:[MatSnackBar, HotelService, DestinationService, DomSanitizer]
    }).compileComponents();
  });
  it('should create component', () => {
    const fixture = TestBed.createComponent(HotelsComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
})
