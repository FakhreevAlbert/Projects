import {Injectable} from "@angular/core";
import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { Router } from '@angular/router';
import 'rxjs/add/operator/catch';
import {AuthService} from "../../services/auth.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService,
              private router: Router) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.authService.isAuth()) {
      const token = this.authService.getAuth();
      req = req.clone({
        setHeaders: {
          'Authorization': 'Bearer ' + token
        }
      });
    }

    return next.handle(req).catch((error: Error) => {
      if (error instanceof HttpErrorResponse) {
        if (error.status === 401 && this.router.url !== '/auth/login') {
          this.router.navigate(['/auth/login']);
          this.authService.removeAuth();
          return Observable.throw({error: {message: 'Authentication required'}});
        }

        if (error.status === 403) {
          alert('Oops');
          return Observable.throw({error: {message: 'Authentication required'}});
        }

        return Observable.throw({error: {message: 'Unknown error'}});
      }
    });
  }
}
