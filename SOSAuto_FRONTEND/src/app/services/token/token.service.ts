import { Injectable } from '@angular/core';
import {jwtDecode} from "jwt-decode";
import {JwtPayload} from "../token/JwtPayload";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class TokenService {


  constructor(private http: HttpClient, private router: Router) {}

  set token(token: string) {
      localStorage.setItem('jwt', token);
    }

    get token(){
        return localStorage.getItem('jwt') as string;
    }

  getSubFromJwt(token: string): string {
    const decodedToken = jwtDecode<JwtPayload>(token);
    return decodedToken.sub;
  }

  getRoleFromJwt(token: string): string {
    const decodedToken = jwtDecode<JwtPayload>(token);
    return decodedToken.role;
  }

  getIDFromJwt(token: any): number {
    const decodedToken = jwtDecode<JwtPayload>(token);
    return decodedToken.id;
  }
  getIDFromLocalJwt(){
    const decodedToken = jwtDecode<JwtPayload>(this.token);
    return decodedToken.id;
  }

  logout(): void {
    localStorage.removeItem('jwt');
    this.router.navigate(['/']);
  }
}
