import { Component, OnInit } from '@angular/core';
import {Manager} from "../../domain/manager";
import {ManagerService} from "../../services/manager.service";
import {Department} from "../../domain/department";

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.scss']
})
export class ManagerComponent implements OnInit {
  managers: Manager[] = [];
  department: Department;

  constructor(private managerService: ManagerService) { }

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
    this.managerService.removeManager(id).subscribe(_=>this.load(), error=>console.log(error));
  }


  private load(){
    this.managerService.getManagers().subscribe(
      data=>this.managers=data,
      error=>console.log(error)
    );
  }

}
