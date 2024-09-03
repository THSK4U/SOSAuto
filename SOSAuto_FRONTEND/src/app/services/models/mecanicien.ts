/* tslint:disable */
/* eslint-disable */
export interface Mecanicien {
  disponible?: 'DISPONIBLE' | 'INDISPONIBLE';
  email?: string;
  latitude?: number;
  longitude?: number;
  nom?: string;
  password?: string;
  personneid?: number;
  prenom?: string;
  role?: 'ADMIN' | 'AUTO' | 'MECA';
}
