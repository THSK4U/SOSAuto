import {AfterViewInit, Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import * as mapboxgl from 'mapbox-gl';
import * as MapboxGeocoder from '@mapbox/mapbox-gl-geocoder';
import axios from 'axios'
import {ApiService} from "../../../services/services/api.service";
import {MecanicienDto} from "../../../services/models/mecanicien-dto";
import {CreerMecanicien$Params} from "../../../services/fn/operations/creer-mecanicien";
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
  imageProofPreviewUrl: string | null = null;
  imagePreviewUrl: string | null = null;


  constructor(private fb: FormBuilder,
              private Service: ApiService
  ) {}

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

  async onSubmit() {
    if (this.registerForm.valid) {
      const formData = this.registerForm.value;
      console.log('Form Data:', this.registerForm.value);

      if (formData.nationalIdCardUrl) {
        formData.nationalIdCardUrl = await this.uploadImageToCloudinary(formData.nationalIdCardUrl);
      }
      if (formData.nationalIdCardUrl) {
        formData.proofOfProfessionUrl = await this.uploadImageToCloudinary(formData.proofOfProfessionUrl);
      }
      console.log('Form Data after:', formData);

      this.Service.creerMecanicien$Response({
        body: formData
      }).subscribe(
          data => {
              console.log('Mecanicien created successfully:', data);
          }
      )

    }
  }

  onFileSelected(event: any, controlName: string): void {
    const file = event.target.files[0];
    if (file && file.type.match(/image\/*/) != null) {
      const previewUrl = URL.createObjectURL(file);
      this.registerForm.patchValue({
        [controlName]: file
      });
      this.registerForm.get(controlName)?.markAsTouched();
      if (controlName === 'nationalIdCardUrl') {
        this.imagePreviewUrl = previewUrl;
      } else if (controlName === 'proofOfProfessionUrl') {
        this.imageProofPreviewUrl = previewUrl;
      }
    } else {
      alert('Veuillez sélectionner une image valide');
    }
  }

  uploadImageToCloudinary(file: File): Promise<string> {
    const cloudinaryUrl = 'https://api.cloudinary.com/v1_1/dflocbrja/image/upload';
    const unsignedUploadPreset = 'sosauto';

    const formData = new FormData();
    formData.append('file', file);
    formData.append('upload_preset', unsignedUploadPreset);

    return axios.post(cloudinaryUrl, formData)
      .then(response => {
        if (response.data.secure_url) {
          return response.data.secure_url;
        } else {
          throw new Error('Upload failed');
        }
      })
      .catch(error => {
        throw error;
      });
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
