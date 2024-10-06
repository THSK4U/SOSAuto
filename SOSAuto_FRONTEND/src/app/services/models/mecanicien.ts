/* tslint:disable */
/* eslint-disable */
import {Role} from "./Role";

export interface Mecanicien {
  Notation?: number;
  disponible?: 'INDISPONIBLE' | 'DISPONIBLE';
  email?: string;
  latitude?: number;
  longitude?: number;
  nationalIdCardUrl?: string;
  nom?: string;
  numTelephone?: string;
  password?: string;
  personneid?: number;
  prenom?: string;
  proofOfProfessionUrl?: string;
  role?: Role;
}
