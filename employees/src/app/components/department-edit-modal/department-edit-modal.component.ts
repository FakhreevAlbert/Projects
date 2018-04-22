import {Component, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {Department} from "../../domain/department";
import {NgForm} from "@angular/forms";
import {DepartmentService} from "../../services/department.service";
declare const $: any;

@Component({
  selector: 'app-department-edit-modal',
  templateUrl: './department-edit-modal.component.html',
  styleUrls: ['./department-edit-modal.component.scss']
})
export class DepartmentEditModalComponent implements OnInit {

  @Output() save = new EventEmitter();
  @ViewChild('departmentEditForm') form: NgForm;


  department:Department;


  constructor(private departmentService: DepartmentService) {
    this.clear();
  }

  ngOnInit() {
    $(document).ready(function(){
      // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
      $('#departmentEditModal').modal({
        dismissible: false
      });
    });
  }

  onAdd(){
    this.clear();
    this.show();
  }
  onEdit(id: number){
    this.departmentService.getDepartmentById(id).subscribe(
      data=>{
        this.department = data;
        this.show();
      },
      error=>console.log(error)
    );

  }

  onSave() {
    if (this.department.id === 0) {
      this.departmentService.createDepartment(this.department).subscribe(
        _ => {
          this.save.emit();
          this.close();
          this.clear();
          this.reset();
        },
        error => console.log(error)
      );


    } else {
      this.departmentService.updateDepartment(this.department.id, this.department).subscribe(
        _ => {
          this.save.emit();
          this.close();
          this.clear();
          this.reset();
        },
        error => console.log(error)
      );
    }
  }


  onCancel() {
    this.close();
    this.clear();
    this.reset();
  }

  private clear(){
    this.department = new Department(0,'','');
  }

  private reset() {
    this.form.reset();
  }

  private  show() {
    $('#departmentEditModal').modal('open');
  }

  private close() {
    $('#departmentEditModal').modal('close');
  }


}
