import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {ICustomer} from '../../../models/ICustomer';
import {CustomerService} from '../../../services/customer.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  id: number;
  header: string;

  constructor(private route: ActivatedRoute, private customerService: CustomerService, private router: Router) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.header = this.id === 0? 'Add Customer' : 'Edit Customer';
  }

  onSubmit(form: NgForm){
    let customer: ICustomer = {
      id: form.value.id,
      fullName: form.value.fullName,
      birthday: form.value.birthday,
      idCard: form.value.idCard,
      phoneNumber: form.value.phoneNumber,
      email: form.value.email,
      address: form.value.address
    }

    this.customerService.onAdd(customer);
    this.router.navigateByUrl('');
  }

}
