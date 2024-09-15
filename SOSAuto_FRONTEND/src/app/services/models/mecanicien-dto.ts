/* tslint:disable */
/* eslint-disable */
export interface MecanicienDto {
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
  role?: 'ADMIN' | 'AUTO' | 'MECA';
}
