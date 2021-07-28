import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../services/customer.service';
import {ICustomer} from '../../models/ICustomer';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customers: ICustomer[];

  constructor(private customerService:CustomerService) { }

  ngOnInit(): void {
    this.customers = this.customerService.getAllCustomer();
  }

}
