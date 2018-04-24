import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeFindCardComponent } from './employee-find-card.component';

describe('EmployeeFindCardComponent', () => {
  let component: EmployeeFindCardComponent;
  let fixture: ComponentFixture<EmployeeFindCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeFindCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeFindCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
