import { TestBed } from '@angular/core/testing';
import {HttpClientModule} from '@angular/common/http';
import { AuthService } from 'src/app/services/authority/auth.service';
import { RouterTestingModule } from '@angular/router/testing';
import { RegisterComponent } from './register.component';

describe('Register', () => {

  beforeEach(async () => {
    await TestBed.configureTestingModule({
     imports:[HttpClientModule,
        RouterTestingModule],
      declarations: [
        RegisterComponent,
      ],
      providers:[AuthService]
    }).compileComponents();
  });
  it('should create component', () => {
    const fixture = TestBed.createComponent(RegisterComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
})
