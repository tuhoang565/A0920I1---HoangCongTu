import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CustomerService} from '../../../services/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ICustomer} from '../../../models/ICustomer';
import {ICustomerType} from '../../../models/ICustomerType';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  id: number;
  customerTypes: any = [];
  customer: ICustomer = new class implements ICustomer {
    address: string;
    birthday: string;
    customerType: ICustomerType;
    email: string;
    fullName: string;
    id: number;
    idCard: string;
    phoneNumber: string;
  };

  editForm = this.formBuilder.group({
    fullName: [''],
    birthday: [''],
    idCard: [''],
    phoneNumber: [''],
    email: [''],
    address: [''],
    customerType: ['']
  });


  constructor(private formBuilder: FormBuilder, private customerService: CustomerService,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.getAllCustomerTypeList();
    this.id = this.activatedRoute.snapshot.params.id;
    this.customerService.findById(this.id).subscribe((result)=>{
      this.editForm.setValue(result);
      }
    );
  }

  editCustomer(){
    this.customer = this.editForm.value;
    this.customerService.editCustomer(this.customer, this.id).subscribe(data =>{
      alert('update successful');
    })
  }

  getAllCustomerTypeList(){
    this.customerService.getAllCustomerType().subscribe(data =>{
      this.customerTypes = data;
    })
  }
}
