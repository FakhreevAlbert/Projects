import { Component, OnInit } from '@angular/core';
import {Employee} from "../../domain/employee";
import {EmployeeService} from "../../services/employee.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Department} from "../../domain/department";

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.scss']
})
export class EmployeeDetailsComponent implements OnInit {

  private id: number;

  employee: Employee;
  department: Department;

  constructor(
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router) {

  }

  ngOnInit(){
     this.id = Number(this.route.snapshot.paramMap.get('id'));
    if (isNaN(this.id)){
      this.router.navigate(['/employees']);
      return;
    }

    this.load(this.id);
  }
  onLike(id: number){
    this.employeeService.like(id).subscribe(_=>this.load(this.id), error =>console.log(error));
    this.load(id);
  }

  onDislike(id: number){
    this.employeeService.dislike(id).subscribe(_=>this.load(this.id), error=>console.log(error));
    this.load(id);
  }
  onLogout(){
    localStorage.removeItem('token');
  }

  onRemove(id: number){
    this.employeeService.remove(id).subscribe(_=>this.router.navigate(['/employees']), error=>console.log(error));
    this.load(id);
  }
  onChange(){
    this.load(this.id);
  }


  private load (id){
    this.employeeService.getById(id).subscribe(
      data=>this.employee = data,
      error=>console.log(error)
    );
  }
}
