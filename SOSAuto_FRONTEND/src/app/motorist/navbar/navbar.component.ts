import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {TokenService} from "../../services/token/token.service";

@Component({
  selector: 'app-navbar-Moto',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  constructor(
    private service:TokenService
  ){}
  logout() {
    this.service.logout()
  }
}
