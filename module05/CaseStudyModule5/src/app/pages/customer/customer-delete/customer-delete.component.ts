import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CustomerService} from '../../../services/customer.service';

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {

  constructor(private http: HttpClient, private customerService: CustomerService) { }

  ngOnInit(): void {

  }

  deleteCustomer(id: number){
    this.customerService.deleteCustomer(id)
      .subscribe(data =>{
        alert("Customer delete")
      })
  }
}
