import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../../services/services/api.service';
import { ToastrService } from 'ngx-toastr';
import { GetDemandeById$Params } from '../../services/fn/operations/get-demande-by-id';
import * as mapboxgl from 'mapbox-gl';
import { DemandeDepannageDto } from '../../services/models/demande-depannage-dto';

@Component({
  selector: 'app-demandedetail',
  templateUrl: './demandedetail.component.html',
  styleUrls: ['./demandedetail.component.scss']
})
export class DemandedetailComponent implements OnInit {

  private readonly mapboxAccessToken = 'pk.eyJ1Ijoic29zYXV0byIsImEiOiJjbTBlZmhudTkwNm16MmpzN3RkZDJiZ2MzIn0.NCq9laQd2WA2o0fdBKhfOw';
  private map!: mapboxgl.Map;
  private userLat!: number;
  private userLng!: number;
  demandeId: number | undefined;
  demandes!: DemandeDepannageDto[];

  constructor(
    private route: ActivatedRoute,
    private service: ApiService,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.demandeId = Number(this.route.snapshot.paramMap.get('demandeid'));

    if (this.demandeId) {
      this.fetchDemandeDetails(this.demandeId);
      this.initializeMap();
    } else {
      this.toastr.error('ID de demande invalide', 'Erreur!');
    }
  }

  fetchDemandeDetails(demandeId: number): void {
    const params: GetDemandeById$Params = { id: demandeId };
    this.service.getDemandeById$Response(params).subscribe(
      (response) => {
        this.demandes = [response.body] || [];
        this.addDemandeMarkers();
        console.log('Détails de la demande:', this.demandes);
      },
      (error) => {
        this.toastr.error('Erreur lors de la récupération des détails de la demande', 'Erreur!');
        console.error('Erreur:', error);
      }
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
    const geolocateControl = new mapboxgl.GeolocateControl({
      positionOptions: { enableHighAccuracy: true },
      trackUserLocation: true,
      showUserHeading: true,
      showAccuracyCircle: false,
    });

    this.map.addControl(geolocateControl);
    this.setupGeolocation();
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
          .setPopup(new mapboxgl.Popup().setHTML(`
          <div class="card-body-mark text-center d-flex flex-column align-items-center border-radius: 10px">
            <h5 class="card-title mb-2">
              ${demande.automobiliste?.nom?.toUpperCase() || 'Unknown'}
            </h5>
            <h6 class="card-subtitle mb-2 text-danger">${demande.panne?.nom || 'Unknown'}</h6>
            <p class="card-text">${demande.description || 'Unknown'}</p>
          </div>
        `))
          .addTo(this.map);

        this.getDirections(demande.latitude, demande.longitude);
      }
    });
  }

  private setupGeolocation(): void {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
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
        'line-color': '#007bff',
        'line-width': 5
      }
    });
  }
}
