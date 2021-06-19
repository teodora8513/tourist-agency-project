import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../services/authority/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  public logout(): void {
    this.authService.logout();
  }
}