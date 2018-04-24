import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeeComponent} from "./components/employee/employee.component";
import {EmployeeDetailsComponent} from "./components/employee-details/employee-details.component";
import {DepartmentComponent} from "./components/department/department.component";
import {DepartmentDetailsComponent} from "./components/department-details/department-details.component";
import {ManagerComponent} from "./components/manager/manager.component";
import {ManagerDetailsComponent} from "./components/manager-details/manager-details.component";
import {EmployeeFindComponent} from "./components/employee-find/employee-find.component";
import {LoginComponent} from "./components/login/login.component";

const routes: Routes = [
  {path:'employees', component: EmployeeComponent},
  {path:'employee/:id', component: EmployeeDetailsComponent},
  {path:'departments', component: DepartmentComponent},
  {path: 'department/:id', component: DepartmentDetailsComponent},
  {path: 'managers', component: ManagerComponent},
  {path: 'manager/:id', component: ManagerDetailsComponent},
  {path: 'find', component: EmployeeFindComponent},
  {path: 'auth/login', component: LoginComponent},
  {path: '**', redirectTo: '/employees'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
