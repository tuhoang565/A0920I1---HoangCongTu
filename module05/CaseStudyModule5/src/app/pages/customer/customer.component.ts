import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../services/customer.service';
import {ICustomer} from '../../models/ICustomer';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customers: ICustomer[] = [];
  key: string = 'id';
  reverse: boolean = false;
  p: number = 1;

  constructor(private customerService:CustomerService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getAllCustomer();
  }

  getAllCustomer(){
    this.customerService.getAllCustomer().subscribe(data =>{
      this.customers = data;
    })
  }

  deleteCustomer(id: number){
    this.customerService.deleteCustomer(id)
      .subscribe(data =>{
        alert("Customer delete successful");
        this.ngOnInit();
      });
  }

  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }
}
