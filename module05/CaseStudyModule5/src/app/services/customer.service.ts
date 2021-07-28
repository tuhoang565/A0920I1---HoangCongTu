import { Injectable } from '@angular/core';
import {ICustomer} from '../models/ICustomer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: ICustomer[]=[
    {
      id: 1,
      fullName: "Tu Hoang",
      birthday: "20/1/1994",
      idCard: "123",
      phoneNumber: "0905123123",
      email: "tu@gmail.com",
      address: "Hue"
    },
    {
      id: 2,
      fullName: "Tu Hoang",
      birthday: "20/1/1994",
      idCard: "123",
      phoneNumber: "0905123123",
      email: "tu@gmail.com",
      address: "Hue"
    },
    {
      id: 3,
      fullName: "Tu Hoang",
      birthday: "20/1/1994",
      idCard: "123",
      phoneNumber: "0905123123",
      email: "tu@gmail.com",
      address: "Hue"
    },
  ];
  constructor() { }

  getAllCustomer(){
    return this.customers;
  }
}
