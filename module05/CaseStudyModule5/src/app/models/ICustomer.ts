import {ICustomerType} from './ICustomerType';

export interface ICustomer {
  id : number;
  fullName: string;
  birthday: string;
  idCard: string;
  phoneNumber: string;
  email: string;
  address: string;
  customerType: ICustomerType
}
