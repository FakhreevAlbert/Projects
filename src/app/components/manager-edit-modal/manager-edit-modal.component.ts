import {Component, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {ManagerService} from "../../services/manager.service";
import {Manager} from "../../domain/manager";
import {Department} from "../../domain/department";
import {DepartmentService} from "../../services/department.service";
declare const $: any;

@Component({
  selector: 'app-manager-edit-modal',
  templateUrl: './manager-edit-modal.component.html',
  styleUrls: ['./manager-edit-modal.component.scss']
})
export class ManagerEditModalComponent implements OnInit {

  @Output() save = new EventEmitter();
  @ViewChild('managerEditForm') form: NgForm;

  manager: Manager;
  department: Department;
  departments: Department[]=[];
  departmentId = 16;

  constructor(private managerService: ManagerService,
              private departmentService: DepartmentService) {
    this.clear();
  }

  ngOnInit() {
    $(document).ready(function(){
      // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
      $('#managerEditModal').modal({
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
    this.managerService.getManagerById(id).subscribe(
      data=>{
        this.manager = data;
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
    if (this.manager.id === 0) {
      this.managerService.createManager(this.departmentId, this.manager).subscribe(
        _ => {
          this.save.emit();
          this.close();
          this.clear();
          this.reset();
        },
        error=>{
          console.log(error);
          alert("У выбранного вами отдела уже есть менеджер")
        }

      )


    } else {
      this.managerService.updateManager(this.manager.id, this.departmentId, this.manager).subscribe(
        _ => {
          this.save.emit();
          this.close();
          this.clear();
          this.reset();
        },
        error=> {
          console.log(error);
          alert("У выбранного вами отдела уже есть менеджер")
        }




      );
    }
  }



  onCancel() {
    this.close();
    this.clear();
    this.reset();
  }

  private clear(){
    this.manager = new Manager(0,'','','','','');
  }

  private reset() {
    this.form.reset();
  }

  private  show() {
    $('#managerEditModal').modal('open');
  }

  private close() {
    $('#managerEditModal').modal('close');
  }

}
