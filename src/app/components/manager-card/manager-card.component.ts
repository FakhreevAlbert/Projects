import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Department} from "../../domain/department";
import {Manager} from "../../domain/manager";

@Component({
  selector: 'app-manager-card',
  templateUrl: './manager-card.component.html',
  styleUrls: ['./manager-card.component.scss']
})
export class ManagerCardComponent implements OnInit {
  @Input() manager: Manager;
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
