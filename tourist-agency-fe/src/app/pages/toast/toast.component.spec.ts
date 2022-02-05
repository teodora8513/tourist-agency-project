import { TestBed } from '@angular/core/testing';
import { ToastComponent } from './toast.component';

describe('Toast', () => {

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [],
      declarations: [
        ToastComponent,
      ],
      providers:[]
    }).compileComponents();
  });
  it('should create component', () => {
    const fixture = TestBed.createComponent(ToastComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
})
