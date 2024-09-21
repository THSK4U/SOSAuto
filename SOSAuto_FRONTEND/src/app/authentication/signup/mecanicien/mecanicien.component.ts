import {AfterViewInit, Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import * as mapboxgl from 'mapbox-gl';
import * as MapboxGeocoder from '@mapbox/mapbox-gl-geocoder';

@Component({
  selector: 'app-mecanicien',
  templateUrl: './mecanicien.component.html',
  styleUrls: ['./mecanicien.component.scss']
})
export class MecanicienComponent implements OnInit {
  registerForm!: FormGroup;
  hidePassword = true;
  errorMsg: Array<string> = [];
  currentStep = 1;
  private readonly mapboxAccessToken = 'pk.eyJ1Ijoic29zYXV0byIsImEiOiJjbTBlZmhudTkwNm16MmpzN3RkZDJiZ2MzIn0.NCq9laQd2WA2o0fdBKhfOw';
  private map!: mapboxgl.Map;
  private marker!: mapboxgl.Marker;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.registerForm = this.fb.group({
      nom: ['', Validators.required],
      prenom: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      numTelephone: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      nationalIdCardUrl: [''],
      proofOfProfessionUrl: [''],
      latitude: [''],
      longitude: ['']
    });
  }

  nextStep() {
    if (this.currentStep < 3) {
      this.currentStep++;
    }
    if (this.currentStep === 3) {
      setTimeout(() => {
        this.initializeMap();
        this.addControls();
      }, 0);
    }
  }

  prevStep() {
    if (this.currentStep > 1) {
      this.currentStep--;
    }
  }

  onSubmit() {
    if (this.registerForm.valid) {
      this.errorMsg = [];
      console.log(this.registerForm.value);

    } else {
      this.errorMsg.push('Veuillez remplir tous les champs requis.');
    }
  }


  private initializeMap(): void {
    (mapboxgl as any).accessToken = this.mapboxAccessToken;

    this.map = new mapboxgl.Map({
      container: 'map',
      style: 'mapbox://styles/sosauto/cm0efmxws003j01pe3xz531xx',
      zoom: 11,
      center: [-5.5735438, 33.1663341]
    });

    this.map.addControl(new mapboxgl.NavigationControl());
    this.map.scrollZoom.enable();

    const markerElement = document.createElement('img');
    markerElement.src = 'assets/images/Live-Local.png';
    markerElement.style.width = '50px';
    markerElement.style.marginTop = '-15px';

    this.marker = new mapboxgl.Marker({ element: markerElement, draggable: true });

    this.map.on('click', (event: mapboxgl.MapMouseEvent) => {
      const { lng, lat } = event.lngLat;

      this.registerForm.patchValue({
        latitude: lat,
        longitude: lng
      });

      this.marker.setLngLat([lng, lat]).addTo(this.map);

      this.marker.on('dragend', () => {
        const lngLat = this.marker.getLngLat();
        this.registerForm.patchValue({
          latitude: lngLat.lat,
          longitude: lngLat.lng
        });
      });
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
  }

}
