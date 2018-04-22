import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeFindComponent } from './employee-find.component';

describe('EmployeeFindComponent', () => {
  let component: EmployeeFindComponent;
  let fixture: ComponentFixture<EmployeeFindComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeFindComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeFindComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
