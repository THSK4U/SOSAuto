import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedDataService {
  private _userLat!: number;
  private _userLng!: number;

  setUserLocation(lat: number, lng: number): void {
    this._userLat = lat;
    this._userLng = lng;
  }

  getUserLocation(): { lat: number, lng: number } {
    return { lat: this._userLat, lng: this._userLng };
  }
}
