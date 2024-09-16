import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { TokenService } from "../../services/token/token.service";
import { ApiService } from "../../services/services/api.service";
import {PersonneDto} from "../../services/models/personne-dto";

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {
  loginForm!: FormGroup;
  hidePassword = true;
  errorMsg: Array<string> = [];

  constructor(
    private fb: FormBuilder,
    private authentication: ApiService,
    private router: Router,
    private tokenService: TokenService
  ) {}

  ngOnInit() {
    this.loginForm = this.fb.group({
      numTelephone: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      this.errorMsg = [];
      console.log(this.loginForm.value);

      this.authentication.login$Response({
        body: this.loginForm.value
      }).subscribe({
        next: (data) => {
          if (data.body && data.body.jwt) {
            this.tokenService.token = data.body.jwt as string;

            const role = this.tokenService.getRoleFromJwt(this.tokenService.token);
              console.log(role);
            if (role === 'ADMIN') {
              this.router.navigate(['/admin']);
            } else if (role === 'AUTO') {
              this.router.navigate(['/automobiliste']);
            } else if (role === 'MECA') {
              this.router.navigate(['/mecanicien']);
            } else {
              this.router.navigate(['/login']);
            }
          } else {
            this.errorMsg.push("JWT not found in the response");
          }
        },
        error: (error) => {
          this.errorMsg.push("Échec de la connexion. Veuillez réessayer.");
          console.error('Erreur de connexion:', error);
        }
      });
    }
  }

}
