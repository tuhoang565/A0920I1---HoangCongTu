import {IRentType} from './IRentType';

export interface IService {
  id: number;
  code: string;
  name: string;
  area: number;
  floor: number;
  maxPeople: number;
  rentCost: number;
  status: string;
  rentType: IRentType;
}
