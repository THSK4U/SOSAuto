import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-automobiliste',
  templateUrl: './automobiliste.component.html',
  styleUrls: ['./automobiliste.component.scss']
})
export class AutomobilisteComponent implements OnInit {
  registerForm!: FormGroup;
  hidePassword = true;
  errorMsg: Array<string> = [];

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
    });
  }


  onSubmit() {
    if (this.registerForm.valid) {
      this.errorMsg = [];
      console.log(this.registerForm.value);
    } else {
      this.errorMsg.push('Veuillez remplir tous les champs requis.');
    }
  }
}
