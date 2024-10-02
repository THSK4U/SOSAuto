import {Component, OnInit} from '@angular/core';
import {Automobiliste} from "../../../services/models/automobiliste";
import {Mecanicien} from "../../../services/models/mecanicien";
import {ApiService} from "../../../services/services/api.service";

@Component({
  selector: 'app-ges-motorist',
  templateUrl: './ges-motorist.component.html',
  styleUrls: ['./ges-motorist.component.scss']
})
export class GesMotoristComponent  implements OnInit {
  automobilistes: Automobiliste[] = [];

  constructor(private Service: ApiService) {}

  ngOnInit(): void {
    this.getUsers();
  }

  private getUsers(): void {
    this.Service.getAllAutomobiliste().subscribe(
      (data) => {
        this.automobilistes = data;
      },
      (error) => {
        console.error('Error loading users:', error);
      }
    );
  }

}
