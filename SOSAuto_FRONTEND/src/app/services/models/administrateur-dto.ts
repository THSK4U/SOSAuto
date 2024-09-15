/* tslint:disable */
/* eslint-disable */
export interface AdministrateurDto {
  email?: string;
  nationalIdCardUrl?: string;
  nom?: string;
  numTelephone?: string;
  password?: string;
  personneid?: number;
  prenom?: string;
  role?: 'ADMIN' | 'AUTO' | 'MECA';
  username?: string;
}
