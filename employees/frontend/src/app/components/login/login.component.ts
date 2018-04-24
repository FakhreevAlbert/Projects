import { Component, OnInit } from '@angular/core';
import {Authentication} from "../../domain/authentication";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
 auth = new Authentication('', '');

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }
  onLogin(){
    this.authService.authenticate(this.auth);
  }
}
