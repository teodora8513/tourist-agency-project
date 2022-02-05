import { TestBed } from '@angular/core/testing';
import {HttpClientModule} from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { AuthService } from 'src/app/services/authority/auth.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { RouterTestingModule } from '@angular/router/testing';
import { HotelDetailsComponent } from './hotel-details.component';
import { HotelService } from 'src/app/services/hotel/hotel.service';
import { RoomService } from 'src/app/services/room/room.service';
import { FormBuilder } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';

describe('Hotel details', () => {

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, MatSnackBarModule, RouterTestingModule],
      declarations: [
        HotelDetailsComponent,
      ],
      providers:[MatSnackBar, HotelService, RoomService, FormBuilder, DomSanitizer]
    }).compileComponents();
  });
  it('should create component', () => {
    const fixture = TestBed.createComponent(HotelDetailsComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
})
