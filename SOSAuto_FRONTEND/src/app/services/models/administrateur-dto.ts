/* tslint:disable */
/* eslint-disable */
export interface AdministrateurDto {
  email?: string;
  nom?: string;
  password?: string;
  personneid?: number;
  prenom?: string;
  role?: 'ADMIN' | 'AUTO' | 'MECA';
}
