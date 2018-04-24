import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { EmployeeDetailsComponent } from './components/employee-details/employee-details.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {EmployeeService} from "./services/employee.service";
import { EmployeeCardComponent } from './components/employee-card/employee-card.component';
import { EmployeeEditModalComponent } from './components/employee-edit-modal/employee-edit-modal.component';
import {FormsModule} from "@angular/forms";
import { DepartmentComponent } from './components/department/department.component';
import { DepartmentDetailsComponent } from './components/department-details/department-details.component';
import { ManagerComponent } from './components/manager/manager.component';
import { ManagerDetailsComponent } from './components/manager-details/manager-details.component';
import {DepartmentService} from "./services/department.service";
import {ManagerService} from "./services/manager.service";
import { DepartmentCardComponent } from './components/department-card/department-card.component';
import { ManagerCardComponent } from './components/manager-card/manager-card.component';
import { DepartmentEditModalComponent } from './components/department-edit-modal/department-edit-modal.component';
import { ManagerEditModalComponent } from './components/manager-edit-modal/manager-edit-modal.component';
import { EmployeeFindComponent } from './components/employee-find/employee-find.component';
import { LoginComponent } from './components/login/login.component';
import {AuthService} from "./services/auth.service";
import {AuthInterceptor} from "./components/interceptors/auth-interceptor";
import { EmployeeFindCardComponent } from './components/employee-find-card/employee-find-card.component';





@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    EmployeeDetailsComponent,
    EmployeeCardComponent,
    EmployeeEditModalComponent,
    DepartmentComponent,
    DepartmentDetailsComponent,
    ManagerComponent,
    ManagerDetailsComponent,
    DepartmentCardComponent,
    ManagerCardComponent,
    DepartmentEditModalComponent,
    ManagerEditModalComponent,
    EmployeeFindComponent,
    LoginComponent,
    EmployeeFindCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    EmployeeService,
    DepartmentService,
    ManagerService,
    AuthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
