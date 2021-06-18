import { Component, OnInit } from '@angular/core';
import {Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public formConfiguration: any;
  public error: string;

  constructor() { }

  ngOnInit(): void {
    this.initializeFormConfiguration();
  }

  public onSubmit($event: any): void{
  }

  private initializeFormConfiguration(): void{
    this.formConfiguration = {
      controls: [{
        controlName: 'firstName',
        type: 'text',
        placeholder: 'First name',
        validators: [Validators.required],
        error: 'Firstname not valid'
      }, {
        controlName: 'lastName',
        type: 'text',
        placeholder: 'Last name',
        validators: [Validators.required],
        error: 'Last name not valid'
      }, {
        controlName: 'username',
        type: 'text',
        placeholder: 'E-mail',
        validators: [Validators.required, Validators.email],
        error: 'Email not valid'
      },  {
        controlName: 'password',
        type: 'password',
        placeholder: 'Password',
        validators: [Validators.required],
        error: 'Password not valid'
      },  {
        controlName: 'rePassword',
        type: 'password',
        placeholder: 'RePassword',
        validators: [Validators.required],
        error: 'RePassword not valid'
      }],
      navigation: {
        text: 'Back to login',
        path: ['/login']
      }
    };
  }
}
