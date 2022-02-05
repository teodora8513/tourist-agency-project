import { Component } from '@angular/core';
import { TestBed } from '@angular/core/testing';
import { BasicLayoutComponent } from './basic-layout.component';


describe('Basic layout', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        BasicLayoutComponent,

      ]
    }).compileComponents();
  });
  it('should create component', () => {
    const fixture = TestBed.createComponent(BasicLayoutComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
})
