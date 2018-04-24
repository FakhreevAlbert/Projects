import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Department} from "../../domain/department";
import {Employee} from "../../domain/employee";

@Component({
  selector: 'app-employee-find-card',
  templateUrl: './employee-find-card.component.html',
  styleUrls: ['./employee-find-card.component.scss']
})
export class EmployeeFindCardComponent implements OnInit {
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
