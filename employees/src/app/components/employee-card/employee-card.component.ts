import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Employee} from "../../domain/employee";
import {Department} from "../../domain/department";

@Component({
  selector: 'app-employee-card',
  templateUrl: './employee-card.component.html',
  styleUrls: ['./employee-card.component.scss']
})
export class EmployeeCardComponent implements OnInit {
  @Input() employee: Employee;
  @Input() department: Department;
  @Output() like = new EventEmitter();
  @Output() dislike = new EventEmitter();
  @Output() remove = new EventEmitter();
  @Output() edit = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }

  onLike() {
    this.like.emit();
  }

  onDislike() {
    this.dislike.emit();
  }

  onRemove() {
    this.remove.emit();
  }

  onEdit() {
    this.edit.emit();
  }

}
