import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Department} from "../domain/department";
import {environment} from "../../environments/environment";
import {Employee} from "../domain/employee";
import {Manager} from "../domain/manager";

@Injectable()
export class DepartmentService {

  constructor(private http: HttpClient) { }

  getDepartments(): Observable<Department[]>{
    return this.http.get<Department[]>(`${environment.api}/departments`);
  }

  getDepartmentById(id: number): Observable<Department>{
    return this.http.get<Department>(`${environment.api}/departments/${id}`);
  }

  createDepartment(department: Department): Observable<any>{
    return this.http.post(`${environment.api}/departments`,
      department,
      {responseType: 'text',
      observe: 'response'});
  }
  updateDepartment(id: number, department: Department): Observable<any>{
    return this.http.put(`${environment.api}/departments/${id}`,
      department,
      {responseType: 'text',
        observe: 'response'});
  }
  removeDepartment(id: number): Observable<any>{
    return this.http.delete(`${environment.api}/departments/${id}`,
      {responseType: 'text',
        observe: 'response'});
  }

  getEmployeeFromDepartment(id: number): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${environment.api}/departments/${id}/employees`);
  }

  getManagerFromDepartment(id: number): Observable<Manager[]>{
    return this.http.get<Manager[]>(`${environment.api}/departments/${id}/manager`);
  }

}
