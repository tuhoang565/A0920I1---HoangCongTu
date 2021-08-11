import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../services/customer.service';
import {ICustomer} from '../../models/ICustomer';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  searchText: string;
  customers: ICustomer[] = [];
  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {

  }

  search() {
    if(this.searchText === ""){
      this.ngOnInit();
    }else {
      this.customers = this.customers.filter(res =>{
        return res.fullName.toLocaleLowerCase().match(this.searchText.toLocaleLowerCase());
      })
    }
  }
}
