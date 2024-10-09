import {LOCALE_ID, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {
  HTTP_INTERCEPTORS,
  HttpClient,
  HttpClientModule,
  provideHttpClient,
  withInterceptors
} from "@angular/common/http";
import {MechanicModule} from "./mechanic/mechanic.module";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatCardModule} from "@angular/material/card";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatIconModule} from "@angular/material/icon";
import {SigninComponent} from "./authentication/signin/signin.component";
import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';
import {ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { SignupComponent } from './authentication/signup/signup.component';
import {MatRadioModule} from "@angular/material/radio";
import { HomeComponent } from './home/home.component';
import { MecanicienComponent } from './authentication/signup/mecanicien/mecanicien.component';
import { AutomobilisteComponent } from './authentication/signup/automobiliste/automobiliste.component';
import {AuthInterceptor} from "./services/token/interceptor/auth.interceptor";
import {MatPaginatorModule} from "@angular/material/paginator";
import { HeaderComponent } from './home/header/header.component';
import { HeroComponent } from './home/hero/hero.component';
import { AboutComponent } from './home/about/about.component';
import { FooterComponent } from './home/footer/footer.component';
import { FeaturesComponent } from './home/features/features.component';

registerLocaleData(localeFr);

@NgModule({
  declarations: [
    AppComponent,
    SigninComponent,
    SignupComponent,
    HomeComponent,
    MecanicienComponent,
    AutomobilisteComponent,
    HeaderComponent,
    HeroComponent,
    AboutComponent,
    FooterComponent,
    FeaturesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MechanicModule,
    MatIconModule,
    MatPaginatorModule,
    MatInputModule,
    ReactiveFormsModule,
    MatCardModule,
    MatButtonModule,
    MatToolbarModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule,
    MatRadioModule,
    FormsModule,
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'fr-FR' },
    provideHttpClient(withInterceptors([AuthInterceptor])),  ],
  exports: [

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
