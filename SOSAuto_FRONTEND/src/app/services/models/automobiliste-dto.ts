/* tslint:disable */
/* eslint-disable */
import { DemandeDepannage } from '../models/demande-depannage';
import { VehiculeDto } from '../models/vehicule-dto';
export interface AutomobilisteDto {
  demandeDepannage?: Array<DemandeDepannage>;
  email?: string;
  nom?: string;
  password?: string;
  personneid?: number;
  prenom?: string;
  role?: 'ADMIN' | 'AUTO' | 'MECA';
  'véhicules'?: Array<VehiculeDto>;
}
