/* tslint:disable */
/* eslint-disable */
import { DemandeDepannage } from '../models/demande-depannage';
import { MecanicienDto } from '../models/mecanicien-dto';
export interface ParticipationDto {
  demande?: DemandeDepannage;
  id?: number;
  mecanicien?: MecanicienDto;
  status?: 'EN_ATTENTE' | 'ACCEPTE' | 'REFUSE' | 'ANNULER';
}
