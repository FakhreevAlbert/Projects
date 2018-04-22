import { Component, OnInit } from '@angular/core';
import {DepartmentService} from "../../services/department.service";
import {Department} from "../../domain/department";

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.scss']
})
export class DepartmentComponent implements OnInit {

  departments: Department[] = [];

  constructor(private departmentService: DepartmentService) { }

  ngOnInit() {
    this.load();
  }


  onSave(){
    this.load();
  }
  onLogout(){
    localStorage.removeItem('token');
  }


  onRemove(id: number){

    this.departmentService.removeDepartment(id).subscribe(_=>this.load(),
        error=>{
         console.log(error);
         alert("Перед удалением отдела, расформируйте менеджера и сотрудников этого отдела")
        });
  }

  private load(){
    this.departmentService.getDepartments().subscribe(
      data=>this.departments=data,
      error=>console.log(error)
    );
  }

}
