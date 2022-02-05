import { Component } from '@angular/core';
import { TestBed } from '@angular/core/testing';
import { FormBuilder } from '@angular/forms';
import {Router} from '@angular/router';
import { BaseRegisterComponent } from './base-register.component'
import { RouterTestingModule } from '@angular/router/testing';

describe('Base register', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule.withRoutes([])
      ],
      declarations: [
        BaseRegisterComponent,

      ],providers:[FormBuilder]
    }).compileComponents();
  });

  it('should create component', () => {
    const fixture = TestBed.createComponent(BaseRegisterComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
})
