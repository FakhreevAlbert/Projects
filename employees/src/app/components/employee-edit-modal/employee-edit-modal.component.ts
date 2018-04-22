import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {Employee} from "../../domain/employee";
import {EmployeeService} from "../../services/employee.service";
import {Department} from "../../domain/department";
import {NgForm} from "@angular/forms";
import {DepartmentService} from "../../services/department.service";
declare const $: any;

@Component({
  selector: 'app-employee-edit-modal',
  templateUrl: './employee-edit-modal.component.html',
  styleUrls: ['./employee-edit-modal.component.scss']
})
export class EmployeeEditModalComponent implements OnInit {

  @Output() save = new EventEmitter();
  @ViewChild('employeeEditForm') form: NgForm;

  employee:Employee;
  department:Department;
  departments: Department[]=[];
  departmentId=16;


  constructor(private employeeService: EmployeeService,
              private departmentService: DepartmentService) {
    this.clear();
  }

  ngOnInit() {
    $(document).ready(function(){
      // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
      $('#employeeEditModal').modal({
        dismissible: false
      });
    });
    this.onLoadDepartments();
  }

  onAdd(){
    this.clear();
    this.show();
  }
  onEdit(id: number){
    this.employeeService.getById(id).subscribe(
      data=>{
        this.employee = data;
        this.show();
      },
      error=>console.log(error)
    );

  }
  onLoadDepartments(){
    this.departmentService.getDepartments().subscribe(
      data=>this.departments=data,
      error=>console.log(error)
    )
  }

  onSave() {
    if (this.employee.id === 0) {
      this.employeeService.create(this.departmentId, this.employee).subscribe(
        _ => {
          this.save.emit();
          this.close();
          this.clear();
          this.reset();
        },
        error => console.log(error)
      );


    } else {
      this.employeeService.update(this.employee.id, this.departmentId, this.employee).subscribe(
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
    this.employee = new Employee(0,'','','','','','',0);
  }

  private reset() {
    this.form.reset();
  }

  private  show() {
    $('#employeeEditModal').modal('open');
  }

  private close() {
    $('#employeeEditModal').modal('close');
  }

}
