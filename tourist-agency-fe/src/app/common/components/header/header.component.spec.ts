import { Component } from '@angular/core';
import { TestBed } from '@angular/core/testing';
import {Router} from '@angular/router';
import { AuthService } from 'src/app/services/authority/auth.service';
import { RouterTestingModule } from '@angular/router/testing';
import { HeaderComponent } from './header.component';
import {HttpClientModule} from '@angular/common/http';

describe('Header', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        HttpClientModule
      ],
      declarations: [
        HeaderComponent,

      ],providers:[AuthService]
    }).compileComponents();
  });

  it('should create component', () => {
    const fixture = TestBed.createComponent(HeaderComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
})
