/* tslint:disable */
/* eslint-disable */
import { AutomobilisteDto } from '../models/automobiliste-dto';
import { Mecanicien } from '../models/mecanicien';
import { Panne } from '../models/panne';
export interface DemandeDepannageDto {
  automobiliste?: AutomobilisteDto;
  dateTime?: string;
  demandeid?: number;
  description?: string;
  etat?: 'A_FAIRE' | 'EN_COURS' | 'TERMINE';
  latitude?: number;
  longitude?: number;
  'mécanicien'?: Mecanicien;
  panne?: Panne;
}
