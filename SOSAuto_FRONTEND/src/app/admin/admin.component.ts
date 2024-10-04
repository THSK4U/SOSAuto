import { Component } from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";
import {filter} from "rxjs/operators";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent {
  title = 'SOSAuto Admin'
  path = ''
  activeLinkIndex = 0;
  constructor(private router: Router) {
      this.checkpath()

    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe(() => {
        this.checkpath();
      });
  }


  status = false;
  addToggle()
  {
    this.status = !this.status;
  }
  private checkpath() {
    const url = this.router.url;
    this.path = this.capitalizePath(url);
    this.setActiveLink(url);
  }

  private capitalizePath(path: string): string {
    if (path.startsWith('/admin')) {
      path = path.replace('/admin', '');
    }
      return path
      .split('/')
      .map(part => part.charAt(0).toUpperCase() + part.slice(1).toLowerCase())
      .join(' ');
  }

  private setActiveLink(url: string) {
    if (url === '/admin') {
      this.activeLinkIndex = 0;
    } else if (url === '/admin/mecanicien') {
      this.activeLinkIndex = 1;
    } else if (url === '/admin/automobiliste') {
      this.activeLinkIndex = 2;
    } else {
      this.activeLinkIndex = -1;
    }
  }
}
