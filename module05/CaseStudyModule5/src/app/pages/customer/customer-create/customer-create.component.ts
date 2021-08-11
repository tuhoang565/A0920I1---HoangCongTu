import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ICustomerType} from '../../../models/ICustomerType';
import {ICustomer} from '../../../models/ICustomer';
import {CustomerService} from '../../../services/customer.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  createForm: FormGroup;
  customerTypeList: any = [];
  customers: any;
  maxDate = new Date();
  minDate = new Date(1900, 1, 1);

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
  constructor(private formBuilder: FormBuilder, private customerService: CustomerService, private route: Router) {
  }

  ngOnInit(): void {
    this.getAllCustomerTypeList();
    this.getAllCustomer();

    this.createForm = this.formBuilder.group({
      fullName: ['', Validators.required],
      birthday: [''],
      idCard: ['', Validators.required && Validators.pattern('^(\\d{9}|\\d{12})$')],
      phoneNumber: ['', Validators.required && Validators.pattern('^((090|091)\\d{7})$')],
      email: ['', Validators.required && Validators.pattern('^[a-z][a-z0-9_\\.]{1,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$')],
      address: ['', Validators.required],
      customerType: ['']
    });
  }

  getAllCustomerTypeList(){
    this.customerService.getAllCustomerType().subscribe(data =>{
      this.customerTypeList = data;
    });
  }

  getAllCustomer(){
    this.customerService.getAllCustomer().subscribe(data =>{
      this.customers = data;
    })
  }

  createCustomer(){
    this.customer = this.createForm.value;

    this.customerService.createCustomer(this.customer).subscribe(data =>{
        alert("Customer added successful");
        this.route.navigateByUrl('customer');
      }, error => {
        alert("Something error");
      })
  }
}
