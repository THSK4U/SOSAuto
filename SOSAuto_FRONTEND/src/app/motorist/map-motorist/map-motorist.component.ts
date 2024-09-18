import { Component } from '@angular/core';
import * as mapboxgl from "mapbox-gl";
import {ApiService} from "../../services/services/api.service";
import * as MapboxGeocoder from "@mapbox/mapbox-gl-geocoder";
import {Mecanicien} from "../../services/models/mecanicien";
import {SharedDataService} from "../../services/token/share-data.service";

@Component({
  selector: 'app-map-motorist',
  templateUrl: './map-motorist.component.html',
  styleUrls: ['./map-motorist.component.scss']
})
export class MapMotoristComponent {

  private readonly mapboxAccessToken = 'pk.eyJ1Ijoic29zYXV0byIsImEiOiJjbTBlZmhudTkwNm16MmpzN3RkZDJiZ2MzIn0.NCq9laQd2WA2o0fdBKhfOw';
  private map!: mapboxgl.Map;
  private mecaniciens: Mecanicien[] = [];
  private KM!: number;
  private userLng!: number;
  private userLat!: number;

  constructor(private apiService: ApiService, private sharedDataService: SharedDataService) {}

  ngOnInit(): void {
    this.initializeMap();
    this.addControls();
    this.setupGeolocation();
    this.loadDemandes();
  }

  private initializeMap(): void {
    (mapboxgl as any).accessToken = this.mapboxAccessToken;

    this.map = new mapboxgl.Map({
      container: 'map',
      style: 'mapbox://styles/sosauto/cm0efmxws003j01pe3xz531xx',
      zoom: 11,
      center: [-6.3599780, 32.3600088]
    });

    this.map.addControl(new mapboxgl.NavigationControl());
    this.map.scrollZoom.enable();

    this.map.on('style.load', () => {
      this.map.setFog({});
    });

  }

  private addControls(): void {
    const geocoder = new MapboxGeocoder({
      accessToken: this.mapboxAccessToken,
      mapboxgl: mapboxgl,
      placeholder: 'Search for a location',
      marker: false
    });

    this.map.addControl(geocoder, 'top-left');

    const geolocateControl = new mapboxgl.GeolocateControl({
      positionOptions: { enableHighAccuracy: true },
      trackUserLocation: true,
      showAccuracyCircle: false,
    });

    this.map.addControl(geolocateControl);

    this.map.on('load', () => {
      geolocateControl.trigger();
    });

  }


  // Continuous location update every time user moves
  private setupGeolocation(): void {
    if (navigator.geolocation) {
      navigator.geolocation.watchPosition(
        this.setUserLocation.bind(this),
        this.handleLocationError.bind(this),
        { enableHighAccuracy: true, timeout: 5000, maximumAge: 0 }
      );
    } else {
      alert('Geolocation is not supported by this browser.');
    }
  }

  private setUserLocation(position: GeolocationPosition): void {
    const userLat = position.coords.latitude;
    const userLng = position.coords.longitude;

    this.userLng = userLng;
    this.userLat = userLat;

    this.sharedDataService.setUserLocation(userLat, userLng);

    this.map.flyTo({
      center: [userLng, userLat],
      zoom: 14,
    });
  }

  private handleLocationError(error: GeolocationPositionError): void {
    console.error('Error getting location:', error);
    alert('Could not retrieve your location. Please make sure location services are enabled.');
  }

  private loadDemandes(): void {
    this.apiService.getAllMecanicien().subscribe(
      (List) => {
        this.mecaniciens = List;
        console.log('Loaded mecaniciens:', this.mecaniciens);
        this.addDemandeMarkers();
      },
      (error) => {
        console.error('Error loading mecaniciens:', error);
      }
    );
  }

  private addDemandeMarkers(): void {
    this.mecaniciens.forEach(List => {
      if (List.latitude && List.longitude) {
        const distance = this.calculateDistance(
          this.userLat, this.userLng,
          List.latitude, List.longitude
        );

        const markerElement = document.createElement('img');
        markerElement.src = 'assets/images/Region.png';
        markerElement.style.width = '50px';
        markerElement.style.height = '50px';
        markerElement.style.marginTop = `-20px`;

        // Add marker to the map

        new mapboxgl.Marker({ element: markerElement })
          .setLngLat([List.longitude, List.latitude])  // Correctly set the marker position
          .setPopup(new mapboxgl.Popup().setHTML(`
            <div class="card-body-mark text-center d-flex flex-column align-items-center">
              <h5 class="card-title mb-2">
                ${List.nom?.toUpperCase() || 'Unknown'} ${List.prenom?.toUpperCase() || 'Unknown'}
              </h5>
              <h6>
                <span class="text-muted" style="font-size: 12px;">à ${distance.toFixed(1)}KM</span>
              </h6>
              <h6 class="card-subtitle mb-2 text-danger">${List.disponible || 'Unknown'}</h6>
              <p class="card-text">${List.numTelephone || 'Unknown'}</p>
              <a href="#" class="btn btn-success mt-2">Demande</a>
            </div>
          `))
          .addTo(this.map);

      } else {
        console.warn('Mecanicien missing coordinates:', List);
      }
    });
  }

  private calculateDistance(lat1: number, lon1: number, lat2: number, lon2: number): number {
    const R = 6371; // Radius of the Earth in km
    const dLat = this.degToRad(lat2 - lat1);
    const dLon = this.degToRad(lon2 - lon1);
    const a =
      Math.sin(dLat / 2) * Math.sin(dLat / 2) +
      Math.cos(this.degToRad(lat1)) * Math.cos(this.degToRad(lat2)) *
      Math.sin(dLon / 2) * Math.sin(dLon / 2);
    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    const distance = R * c;  // Distance in km
    return distance;
  }

  private degToRad(deg: number): number {
    return deg * (Math.PI / 180);
  }


}
