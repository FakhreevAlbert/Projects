import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerEditModalComponent } from './manager-edit-modal.component';

describe('ManagerEditModalComponent', () => {
  let component: ManagerEditModalComponent;
  let fixture: ComponentFixture<ManagerEditModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerEditModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerEditModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
