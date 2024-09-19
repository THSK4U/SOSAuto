import { Component, OnInit } from '@angular/core';
import * as mapboxgl from 'mapbox-gl';
import * as MapboxGeocoder from '@mapbox/mapbox-gl-geocoder';
import { DemandeDepannageDto } from "../../services/models/demande-depannage-dto";
import { ApiService } from "../../services/services/api.service";
// @ts-ignore
import MapboxDirections from '@mapbox/mapbox-gl-directions/dist/mapbox-gl-directions';
import {Router} from "@angular/router";

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements OnInit {

  private readonly mapboxAccessToken = 'pk.eyJ1Ijoic29zYXV0byIsImEiOiJjbTBlZmhudTkwNm16MmpzN3RkZDJiZ2MzIn0.NCq9laQd2WA2o0fdBKhfOw';
  private map!: mapboxgl.Map;
  private demandes: DemandeDepannageDto[] = [];
  private KM!: number;
  private userLng!: number;
  private userLat!: number;


  constructor(private apiService: ApiService,
              private router: Router
              ) {
    (window as any).goToParticipation = this.goToParticipation.bind(this);
  }

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
      showUserHeading: true,
      showAccuracyCircle: false,
    });

    this.map.addControl(geolocateControl);

  }

  private setupGeolocation(): void {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        this.setUserLocation.bind(this),
        this.handleLocationError.bind(this)
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

    this.map.setCenter([userLng, userLat]);
  }

  private handleLocationError(error: GeolocationPositionError): void {
    console.error('Error getting location:', error);
    alert('Could not retrieve your location. Please make sure location services are enabled.');
  }

  private loadDemandes(): void {
    this.apiService.getAllDemande().subscribe(
      (demandes) => {
        this.demandes = demandes.filter(demande => demande.etat === 'A_FAIRE');
        console.log('Loaded demandes:', this.demandes);
        this.addDemandeMarkers();
      },
      (error) => {
        console.error('Error loading demandes:', error);
      }
    );
  }

  private addDemandeMarkers(): void {


    this.demandes.forEach(demande => {
      if (demande.latitude && demande.longitude) {

        const distance = this.calculateDistance(
          this.userLat, this.userLng,
          demande.latitude, demande.longitude)

        const markerElement = document.createElement('img');
        markerElement.src = 'assets/images/WHITE.png';
        markerElement.style.width = '50px';
        markerElement.style.height = '50px';
        markerElement.style.marginTop = `-20px`;


        new mapboxgl.Marker({ element: markerElement })
          .setLngLat([demande.longitude, demande.latitude])
          .setPopup(new mapboxgl.Popup().setHTML(`
            <div class="card-body-mark text-center d-flex flex-column align-items-center border-radius: 10px">
              <h5 class="card-title mb-2">
                ${demande.automobiliste?.nom?.toUpperCase() || 'Unknown'}
                <span class="text-muted" style="font-size: 12px;">à ${this.KM.toFixed(1)}KM</span>
              </h5>
              <h6 class="card-subtitle mb-2 text-danger">${demande.panne?.nom || 'Unknown'}</h6>
              <p class="card-text">${demande.description || 'Unknown'}</p>
          <button class="btn btn-success mt-2" onclick="window.goToParticipation(${demande.demandeid})">Demande</button>
            </div>
          `))
          .addTo(this.map);

      } else {
        console.warn('Demande missing coordinates:', demande);
      }
    });
  }

  private goToParticipation(demandeid: number): void {
    this.router.navigate(['/participation', demandeid]);
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
    const distance = R * c;// Distance in km
    this.KM = distance;
    return distance;
  }

  private degToRad(deg: number): number {
    return deg * (Math.PI / 180);
  }

}
