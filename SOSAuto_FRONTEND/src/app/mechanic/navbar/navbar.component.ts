import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {TokenService} from "../../services/token/token.service";

@Component({
  selector: 'app-navbar-meca',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  constructor(
    private router: Router,
    private service:TokenService
  ){}
  logout() {
    this.service.logout()
  }
}
