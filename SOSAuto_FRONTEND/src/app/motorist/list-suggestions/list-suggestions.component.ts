import {Component, OnInit} from '@angular/core';
import {ApiService} from "../../services/services/api.service";
import {MecanicienDto} from "../../services/models/mecanicien-dto";
import {Mecanicien} from "../../services/models/mecanicien";

@Component({
  selector: 'app-list-suggestions',
  templateUrl: './list-suggestions.component.html',
  styleUrls: ['./list-suggestions.component.scss']
})
export class ListSuggestionsComponent implements OnInit{

  mecaniciens: Mecanicien[] = [];

  constructor(
    private service : ApiService
  ) {
  }

  ngOnInit(): void {
    this.service.getAllMecanicienDesponible().subscribe(
      (List) => {
        this.mecaniciens = List;
      }
    );
  }
}
