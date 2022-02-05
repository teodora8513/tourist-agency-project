import { TestBed } from '@angular/core/testing';
import {HttpClientModule} from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { AuthService } from 'src/app/services/authority/auth.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { RouterTestingModule } from '@angular/router/testing';
import { HotelService } from 'src/app/services/hotel/hotel.service';
import { RoomService } from 'src/app/services/room/room.service';
import { FormBuilder } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { LoginComponent } from './login.component';

describe('Login', () => {

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule,  RouterTestingModule],
      declarations: [
        LoginComponent,
      ],
      providers:[AuthService]
    }).compileComponents();
  });
  it('should create component', () => {
    const fixture = TestBed.createComponent(LoginComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
})
