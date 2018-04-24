import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Department} from "../../domain/department";

@Component({
  selector: 'app-department-card',
  templateUrl: './department-card.component.html',
  styleUrls: ['./department-card.component.scss']
})
export class DepartmentCardComponent implements OnInit {


  @Input() department: Department;
  @Output() remove = new EventEmitter();
  @Output() edit = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }



  onRemove() {
    this.remove.emit();
  }

  onEdit() {
    this.edit.emit();
  }
}
