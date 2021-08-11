import {IPosition} from './IPosition';
import {IEducationDegree} from './IEducationDegree';
import {IDivision} from './IDivision';

export interface IEmployee {
  id: number,
  employeeCode: string,
  fullName: string,
  position: IPosition,
  educationDegree: IEducationDegree,
  division: IDivision,
  birthday: string,
  idCard: string,
  salary: number,
  phoneNumber: string,
  email: string,
  address: string
}
