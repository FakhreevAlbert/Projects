import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../../services/employee.service";
import {Employee} from "../../domain/employee";
import {Department} from "../../domain/department";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {
  employees: Employee[] = [];
  department: Department;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.load();
  }

  onSave(){
    this.load();
  }
  onLogout(){
    localStorage.removeItem('token');
  }

  onLike(id: number){
    this.employeeService.like(id).subscribe(_=>this.load(), error =>console.log(error));
  }

  onDislike(id: number){
    this.employeeService.dislike(id).subscribe(_=>this.load(), error=>console.log(error));
  }

  onRemove(id: number){
    this.employeeService.remove(id).subscribe(_=>this.load(), error=>console.log(error));
  }
  private load(){
    this.employeeService.getDigest().subscribe(
      data=> this.employees = data,
      error=> console.log(error)
    );
  }


}
