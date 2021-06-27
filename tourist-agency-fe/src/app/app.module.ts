import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './pages/home/home.component';
import { HeaderComponent } from './common/components/header/header.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule, MatNavList} from "@angular/material/list";
import {MatButtonModule} from "@angular/material/button";
import { BasicLayoutComponent } from './layouts/basic-layout/basic-layout.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { BaseRegisterComponent } from './common/components/base-register/base-register.component';
import {MatCardModule} from "@angular/material/card";
import {MatInputModule} from "@angular/material/input";
import {HttpClientModule} from "@angular/common/http";
import { ReservationsComponent } from './pages/reservations/reservations/reservations.component';
import { AddReservationComponent } from './pages/add-reservation/add-reservation.component';
import { HotelService } from './services/hotel/hotel.service';
import { HotelsComponent } from './pages/hotels/hotels.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';





@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    BasicLayoutComponent,
    LoginComponent,
    RegisterComponent,
    BaseRegisterComponent,
    ReservationsComponent,
    AddReservationComponent,
    HotelsComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    NgbModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    HttpClientModule,
    FormsModule,
    MatSnackBarModule

  ],
  providers: [HotelService],
  bootstrap: [AppComponent]
})
export class AppModule { }
