import { Component } from '@angular/core';
import { TestBed } from '@angular/core/testing';
import { FormBuilder } from '@angular/forms';
import { ArrangementsService } from 'src/app/services/arrangement/arrangements.service';
import { ArrangementComponent } from './arrangement.component';
import {HttpClientModule} from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HotelService } from 'src/app/services/hotel/hotel.service';
import { TransportationService } from 'src/app/services/transportation/transportation.service';
import { RoomService } from 'src/app/services/room/room.service';
import { DestinationService } from 'src/app/services/destination/destination.service';
import { MatSnackBarModule } from '@angular/material/snack-bar';

describe('Arrangement', () => {

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, MatSnackBarModule],
      declarations: [
        ArrangementComponent,
      ],
      providers:[FormBuilder, MatSnackBar, ArrangementsService, HotelService, TransportationService,
      RoomService, DestinationService]
    }).compileComponents();
  });
  it('should create component', () => {
    const fixture = TestBed.createComponent(ArrangementComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
})
