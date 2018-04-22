import { Injectable } from '@angular/core';
import {Employee} from "../domain/employee";
import {Observable} from "rxjs/Observable";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class EmployeeService {

  constructor(private http: HttpClient) { }

  getDigest(): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${environment.api}/employees`);
  }

  getById(id: number): Observable<Employee>{
    return this.http.get<Employee>(`${environment.api}/employees/${id}`);
  }
  create(id: number, employee: Employee): Observable<any> {
    return this.http.post(`${environment.api}/employees/${id}`,
      employee,
      {responseType: 'text',
      observe: 'response'});
  }
  update(id: number,depId:number, employee: Employee): Observable<any>{
    return this.http.put(`${environment.api}/employees/${id}/${depId}`,
      employee,
      {responseType: 'text',
      observe: 'response'});
  }
  remove(id: number): Observable<any>{
    return this.http.delete(`${environment.api}/employees/${id}`,
      {responseType: 'text',
      observe: 'response'});
  }

  like(id: number): Observable<any>{
    return this.http.post(`${environment.api}/employees/${id}/likes`,
      null,
      {responseType: 'text',
      observe: 'response'});

  }
  dislike(id: number): Observable<any>{
    return this.http.delete(`${environment.api}/employees/${id}/likes`,
      {responseType: 'text',
        observe: 'response'});

  }


  findByNameAndLastname(findword: string): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${environment.api}/employees/${findword}/find`);
  }

}
