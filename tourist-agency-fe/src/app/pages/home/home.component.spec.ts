import { TestBed } from '@angular/core/testing';
import { HomeComponent } from './home.component';


describe('Home', () => {

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        HomeComponent,

      ]
    }).compileComponents();
  });
  it('should create component', () => {
    const fixture = TestBed.createComponent(HomeComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
})
