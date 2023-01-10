import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhonenumbersComponent } from './phonenumbers.component';

describe('PhonenumbersComponent', () => {
  let component: PhonenumbersComponent;
  let fixture: ComponentFixture<PhonenumbersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PhonenumbersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PhonenumbersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
