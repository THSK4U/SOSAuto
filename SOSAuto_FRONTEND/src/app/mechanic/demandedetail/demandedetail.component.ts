import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { ApiService } from '../../services/services/api.service';
import { ToastrService } from 'ngx-toastr';
import { GetDemandeById$Params } from '../../services/fn/operations/get-demande-by-id';
import * as mapboxgl from 'mapbox-gl';
import { DemandeDepannageDto } from '../../services/models/demande-depannage-dto';
import * as MapboxGeocoder from '@mapbox/mapbox-gl-geocoder';
import {interval, Subscription} from "rxjs";
import {switchMap} from "rxjs/operators";
import {GetParticipationById$Params} from "../../services/fn/operations/get-participation-by-id";

@Component({
  selector: 'app-demandedetail',
  templateUrl: './demandedetail.component.html',
  styleUrls: ['./demandedetail.component.scss']
})
export class DemandedetailComponent implements OnInit, OnDestroy {

  private readonly mapboxAccessToken = 'pk.eyJ1Ijoic29zYXV0byIsImEiOiJjbTBlZmhudTkwNm16MmpzN3RkZDJiZ2MzIn0.NCq9laQd2WA2o0fdBKhfOw';
  private map!: mapboxgl.Map;
  private userLat!: number;
  private userLng!: number;
  demandeId: number | undefined;
  demandes!: DemandeDepannageDto[];
  private refreshSubscription?: Subscription;


  constructor(
    private route: ActivatedRoute,
    private service: ApiService,
    private toastr: ToastrService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.demandeId = Number(this.route.snapshot.paramMap.get('demandeid'));

    if (this.demandeId) {
      this.fetchDemandeDetails(this.demandeId);
      this.initializeMap();
      this.startAutoRefresh(this.demandeId);
    } else {
      this.toastr.error('ID de demande invalide', 'Erreur!');
    }
  }
  ngOnDestroy(): void {
    if (this.refreshSubscription) {
      this.refreshSubscription.unsubscribe();
    }
  }
  startAutoRefresh(demandeId: number): void {
    // Refresh every 10 seconds
    this.refreshSubscription = interval(5000)
      .pipe(switchMap(() => this.fetchDemandeDetails(demandeId)))
      .subscribe();
  }


  fetchDemandeDetails(demandeId: number) {
    const params: GetDemandeById$Params = { id: demandeId };

    return this.service.getDemandeById$Response(params).pipe(
      switchMap((response) => {
        this.demandes = [response.body] || [];
        const bodydemande = response.body;

        if (bodydemande.etat === 'TERMINE') {
          this.toastr.success('Merci beaucoup pour votre aide ! Le problème a été résolu avec succès. Nous vous sommes reconnaissants pour votre intervention rapide.', 'Succès !');
          this.router.navigate(['/mecanicien']);
        }
        this.addDemandeMarkers();
        console.log('Détails de la demande:', this.demandes);

        if (!this.demandes) {
          this.toastr.error('Participation non trouvée', 'Erreur!');
          this.router.navigate(['/mecanicien']);
          return [];
        }
        return [];

      })
    );
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

    this.addControls();
    this.setupGeolocation();
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
      showAccuracyCircle: false
    });

    this.map.addControl(geolocateControl);
    this.map.on('load', () => {
      geolocateControl.trigger();
    });
  }

  private addDemandeMarkers(): void {
    this.demandes.forEach(demande => {
      if (demande.latitude && demande.longitude) {
        const markerElement = document.createElement('img');
        markerElement.src = 'assets/images/WHITE.png';
        markerElement.style.width = '50px';
        markerElement.style.height = '50px';
        markerElement.style.marginTop = '-20px';

        const marker = new mapboxgl.Marker({ element: markerElement })
          .setLngLat([demande.longitude, demande.latitude])
          .addTo(this.map);
      }
    });
  }
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
    this.userLat = position.coords.latitude;
    this.userLng = position.coords.longitude;

    this.map.flyTo({
      center: [this.userLng, this.userLat],
      zoom: 14,
    });

    // Automatically get directions after setting user location
    if (this.demandes && this.demandes.length > 0) {
      const demande = this.demandes[0];
      if (demande.latitude && demande.longitude) {
        this.getDirections(demande.latitude, demande.longitude);
      }
    }
  }

  private handleLocationError(error: GeolocationPositionError): void {
    console.error('Error getting location:', error);
    alert('Could not retrieve your location. Please make sure location services are enabled.');
  }

  private getDirections(demandeLat: number, demandeLng: number): void {
    const start = [this.userLng, this.userLat];
    const end = [demandeLng, demandeLat];

    const url = `https://api.mapbox.com/directions/v5/mapbox/driving/${start[0]},${start[1]};${end[0]},${end[1]}?steps=true&geometries=geojson&access_token=${this.mapboxAccessToken}`;

    fetch(url)
      .then(response => response.json())
      .then(data => {
        const route = data.routes[0].geometry.coordinates;
        this.drawRoute(route);
      })
      .catch(error => {
        console.error('Error fetching directions:', error);
      });
  }
  private drawRoute(route: any): void {
    if (this.map.getSource('route')) {
      this.map.removeLayer('route');
      this.map.removeSource('route');
    }

    this.map.addSource('route', {
      type: 'geojson',
      data: {
        type: 'Feature',
        properties: {},
        geometry: {
          type: 'LineString',
          coordinates: route
        }
      }
    });


  this.map.addLayer({
                      id: 'route',
                      type: 'line',
                      source: 'route',
                      layout: {
                        'line-join': 'round',
                        'line-cap': 'round'
                      },
                      paint: {
                        'line-color': '#3887be',
                        'line-width': 5,
                        'line-opacity': 0.75
                      }
                    });

  }


}

