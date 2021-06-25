import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AuthService} from "../../../services/authority/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  public logout(): void {
    this.authService.logout();
  }

  public goToReservations(): void {
    this.router.navigate(['/reservations']);
  }

  public goToAddReservation(): void {
    this.router.navigate(['/add-reservation']);
  }
}
