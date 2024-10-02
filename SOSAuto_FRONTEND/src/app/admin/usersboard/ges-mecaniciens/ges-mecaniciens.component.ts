import {Component, OnInit} from '@angular/core';
import {Automobiliste} from "../../../services/models/automobiliste";
import {Mecanicien} from "../../../services/models/mecanicien";
import {ApiService} from "../../../services/services/api.service";

@Component({
  selector: 'app-ges-mecaniciens',
  templateUrl: './ges-mecaniciens.component.html',
  styleUrls: ['./ges-mecaniciens.component.scss']
})
export class GesMecaniciensComponent  implements OnInit {
  mecaniciens: Mecanicien[] = [];

  constructor(private Service: ApiService) {}

  ngOnInit(): void {
    this.getMecaniciens();
  }


  private getMecaniciens(): void {
    this.Service.getAllMecanicien().subscribe(
      (list) => {
        this.mecaniciens = list;
      },
      (error) => {
        console.error('Error loading mecaniciens:', error);
      }
    );
  }
}
