import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DepartmentEditModalComponent } from './department-edit-modal.component';

describe('DepartmentEditModalComponent', () => {
  let component: DepartmentEditModalComponent;
  let fixture: ComponentFixture<DepartmentEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DepartmentEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DepartmentEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
