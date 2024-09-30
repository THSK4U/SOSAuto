/* tslint:disable */
/* eslint-disable */
import {Role} from "./Role";

export interface AdministrateurDto {
  email?: string;
  nationalIdCardUrl?: string;
  nom?: string;
  numTelephone?: string;
  password?: string;
  personneid?: number;
  prenom?: string;
  role?: Role;
  username?: string;
}
