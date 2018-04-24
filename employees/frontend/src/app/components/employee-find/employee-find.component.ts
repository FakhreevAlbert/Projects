import { Component, OnInit } from '@angular/core';
import {Employee} from "../../domain/employee";
import {EmployeeService} from "../../services/employee.service";

@Component({
  selector: 'app-employee-find',
  templateUrl: './employee-find.component.html',
  styleUrls: ['./employee-find.component.scss']
})
export class EmployeeFindComponent implements OnInit {
  employees: Employee[]=[];
  employee: Employee;



  constructor(
    private employeeService: EmployeeService


  ) { }

  ngOnInit() {

  }
  onLogout(){
    localStorage.removeItem('token');
  }



   onNameAndLastname(findword: string){

    this.employeeService.findByNameAndLastname(findword).subscribe(
      data=>this.employees=data,
      error=>console.log(error)
    );
  }


}
