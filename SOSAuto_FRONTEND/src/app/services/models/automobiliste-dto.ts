/* tslint:disable */
/* eslint-disable */
import { VehiculeDto } from '../models/vehicule-dto';
export interface AutomobilisteDto {
  email?: string;
  nom?: string;
  password?: string;
  personneid?: number;
  prenom?: string;
  role?: 'ADMIN' | 'AUTO' | 'MECA';
  'véhicules'?: Array<VehiculeDto>;
}
