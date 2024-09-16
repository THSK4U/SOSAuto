import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'SOSAuto_FRONTEND';

  constructor(
    private router: Router
  ) {
  }

  Login(){
    this.router.navigate(['/Login']);
  }
}
