import { Component, OnInit } from '@angular/core';
import {Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public formConfiguration: any;
  public error: string;
  constructor() { }

  ngOnInit(): void {
    this.initializeFormConfiguration();
  }

  public onSubmit($event: any): void {
  }

  private initializeFormConfiguration(): void {
    this.formConfiguration = {
      controls: [{
        controlName: 'username',
        type: 'text',
        placeholder: 'E-mail',
        validators: [Validators.required, Validators.email],
        error: 'Email not valid'
      }, {
        controlName: 'password',
        type: 'password',
        placeholder: 'Password',
        validators: [Validators.required],
        error: 'Password not valid'
      }],
      navigation: {
        text: 'Don\'t have an account yet? Register',
        path: ['/register']
      }
    };
  }
}
