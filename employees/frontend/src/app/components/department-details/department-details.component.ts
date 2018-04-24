import { Component, OnInit } from '@angular/core';
import {Department} from "../../domain/department";
import {DepartmentService} from "../../services/department.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Employee} from "../../domain/employee";
import {Manager} from "../../domain/manager";

@Component({
  selector: 'app-department-details',
  templateUrl: './department-details.component.html',
  styleUrls: ['./department-details.component.scss']
})
export class DepartmentDetailsComponent implements OnInit {
  department: Department;
  employees: Employee[] = [];
  employee: Employee;
  managers: Manager[]=[];

  constructor(
    private departmentService: DepartmentService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if(isNaN(id)){
      this.router.navigate(['/departments']);
      return;
    }
    this.departmentService.getDepartmentById(id).subscribe(
      data=>this.department=data,
      error=>console.log(error)
    );
    this.onLoad();
    this.onLoadManager();
  }
  onLogout(){
    localStorage.removeItem('token');
  }
  private onLoad(){
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.departmentService.getEmployeeFromDepartment(id).subscribe(
      data=>this.employees=data,
      error=>console.log(error)
    );
  }
  private onLoadManager(){
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.departmentService.getManagerFromDepartment(id).subscribe(
      data=>this.managers=data,
      error=>console.log(error)
    );
  }


}
