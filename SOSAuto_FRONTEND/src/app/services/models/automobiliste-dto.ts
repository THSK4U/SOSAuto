/* tslint:disable */
/* eslint-disable */
import { DemandeDepannage } from '../models/demande-depannage';
import { VehiculeDto } from '../models/vehicule-dto';
import {Role} from "./Role";
export interface AutomobilisteDto {
  demandeDepannage?: Array<DemandeDepannage>;
  email?: string;
  nationalIdCardUrl?: string;
  nom?: string;
  numTelephone?: string;
  password?: string;
  personneid?: number;
  prenom?: string;
  role?: Role;
  'véhicules'?: Array<VehiculeDto>;
}
