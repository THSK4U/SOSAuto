/* tslint:disable */
/* eslint-disable */
import { Automobiliste } from '../models/automobiliste';
import { Mecanicien } from '../models/mecanicien';
import { Panne } from '../models/panne';
export interface DemandeDepannage {
  automobiliste?: Automobiliste;
  dateTime?: string;
  demandeid?: number;
  description?: string;
  etat?: 'A_FAIRE' | 'EN_COURS' | 'TERMINE';
  latitude?: number;
  longitude?: number;
  'mécanicien'?: Mecanicien;
  panne?: Panne;
}
