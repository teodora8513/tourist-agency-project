import { TestBed } from '@angular/core/testing';
import {HttpClientModule} from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { AddReservationComponent } from './add-reservation.component';
import { AuthService } from 'src/app/services/authority/auth.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { RouterTestingModule } from '@angular/router/testing';

describe('Add reservation', () => {

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, MatSnackBarModule, RouterTestingModule],
      declarations: [
        AddReservationComponent,
      ],
      providers:[MatSnackBar, AuthService, NgbModal]
    }).compileComponents();
  });
  it('should create component', () => {
    const fixture = TestBed.createComponent(AddReservationComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
})
