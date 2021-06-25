import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import {HeaderComponent} from "./common/components/header/header.component";
import {BasicLayoutComponent} from "./layouts/basic-layout/basic-layout.component";
import {LoginComponent} from "./pages/login/login.component";
import {RegisterComponent} from "./pages/register/register.component";
import { ReservationsComponent } from './pages/reservations/reservations/reservations.component';
import { AddReservationComponent } from './pages/add-reservation/add-reservation.component';

const routes: Routes = [
  { path: '', component: HeaderComponent, children: [
      {path: 'home', component: HomeComponent},
      {path: '', redirectTo: '/home', pathMatch: 'full' }
    ]
  },
  {
    path: '', component: BasicLayoutComponent, children: [
      {path: 'login', component: LoginComponent},
      {path: 'register', component: RegisterComponent}
    ]
  },
  {path: 'reservations', component: ReservationsComponent, pathMatch: 'full'},
  {path: 'add-reservation', component: AddReservationComponent, pathMatch: 'full'},
  {path: '**', redirectTo: 'home'}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]

})
export class AppRoutingModule { }
