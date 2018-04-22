import  { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Router} from "@angular/router";
import {environment} from "../../environments/environment";
import {Authentication} from "../domain/authentication";

@Injectable()
export class AuthService {
  constructor(private http: HttpClient, private router: Router) {
  }

  authenticate(auth: Authentication) {
    this.http.post(
      `${environment.oauth}/token`, new HttpParams()
        .append('grant_type', 'password')
        .append('client_id', 'client')
        .append('username', auth.login)
        .append('password', auth.password),
      {
        headers: new HttpHeaders()
          .append('Content-Type', 'application/x-www-form-urlencoded; charset=utf-8')
          .append('Authorization', 'Basic ' + btoa(`client:secret`))
      }).subscribe((data: any) => {
      this.setAuth(data.access_token);
      this.router.navigate(['/employees']);
    });

  }

  getAuth(): string {
    return localStorage.getItem('token');
  }

  setAuth(token: string) {
    localStorage.setItem('token', token);
  }

  removeAuth() {
    localStorage.removeItem('token');
  }

  isAuth() {
    return localStorage.getItem('token') !== null;
  }


}
