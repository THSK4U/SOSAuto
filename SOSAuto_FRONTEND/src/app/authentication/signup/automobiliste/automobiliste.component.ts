import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UploadImage} from "../../../services/services/UploadImage";
import {ApiService} from "../../../services/services/api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-automobiliste',
  templateUrl: './automobiliste.component.html',
  styleUrls: ['./automobiliste.component.scss']
})
export class AutomobilisteComponent implements OnInit {
  registerForm!: FormGroup;
  hidePassword = true;
  errorMsg: Array<string> = [];
  imagePreviewUrl: string | null = null;

  constructor(private fb: FormBuilder,
              private uploadService: UploadImage,
              private Service: ApiService,
              private router: Router) {}

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
    });
  }


  async onSubmit() {
    if (this.registerForm.valid) {
      const formData = this.registerForm.value;
      console.log('Form Data:', this.registerForm.value);

      formData.nationalIdCardUrl = await this.uploadService.uploadImageToCloudinary(formData.nationalIdCardUrl);

      console.log('Form Data after:', formData);

      this.Service.creerAutomobiliste$Response({
        body: formData
      }).subscribe(
        data => {
          console.log('Automobiliste created successfully:', data);
          this.router.navigate(['/login']);
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
        this.imagePreviewUrl = previewUrl;
    } else {
      alert('Veuillez sélectionner une image valide');
    }
  }
}
