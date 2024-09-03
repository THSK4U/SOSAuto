/* tslint:disable */
/* eslint-disable */
import { DemandeDepannage } from '../models/demande-depannage';
import { Mecanicien } from '../models/mecanicien';
export interface ParticipationDto {
  demande?: DemandeDepannage;
  id?: number;
  mecanicien?: Mecanicien;
  status?: 'EN_ATTENTE' | 'ACCEPTE' | 'REFUSE';
}
