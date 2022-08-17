import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HorastrabajadasComponent } from './horastrabajadas.component';

describe('HorastrabajadasComponent', () => {
  let component: HorastrabajadasComponent;
  let fixture: ComponentFixture<HorastrabajadasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HorastrabajadasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HorastrabajadasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
