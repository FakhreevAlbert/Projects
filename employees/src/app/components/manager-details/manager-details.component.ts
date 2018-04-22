import { Component, OnInit } from '@angular/core';
import {Manager} from "../../domain/manager";
import {ManagerService} from "../../services/manager.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Department} from "../../domain/department";

@Component({
  selector: 'app-manager-details',
  templateUrl: './manager-details.component.html',
  styleUrls: ['./manager-details.component.scss']
})
export class ManagerDetailsComponent implements OnInit {
  manager: Manager;
  department: Department;

  constructor(private managerService: ManagerService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (isNaN(id)){
      this.router.navigate(['/managers']);
      return;
    }
    this.managerService.getManagerById(id).subscribe(
      data=>this.manager = data,
      error=>console.log(error)
    );
  }
  onLogout(){
    localStorage.removeItem('token');
  }

}
