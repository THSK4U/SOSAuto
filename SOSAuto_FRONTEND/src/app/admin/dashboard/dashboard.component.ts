import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {
  totalUsers = 1234
  avtiveMecanics = 42
  activeRequests = 42
  totalRequests = 60

}
