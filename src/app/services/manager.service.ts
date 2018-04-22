import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Manager} from "../domain/manager";
import {environment} from "../../environments/environment";
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';

@Injectable()
export class ManagerService {

  constructor(private http: HttpClient) { }

  getManagers(): Observable<Manager[]>{
    return this.http.get<Manager[]>(`${environment.api}/managers`);
  }

  getManagerById(id: number): Observable<Manager>{
    return this.http.get<Manager>(`${environment.api}/managers/${id}`);
  }

  createManager(id: number,manager: Manager): Observable<any>{
    return this.http.post(`${environment.api}/managers/${id}`,
      manager,
      {responseType: 'text',
      observe: 'response'});
  }



  updateManager(id: number, depId: number, manager: Manager): Observable<any>{
    return this.http.put(`${environment.api}/managers/${id}/${depId}`,
      manager,
      {responseType: 'text',
        observe: 'response'});
  }
  removeManager(id: number): Observable<any>{
    return this.http.delete(`${environment.api}/managers/${id}`,
      {responseType: 'text',
        observe: 'response'});
  }


}
