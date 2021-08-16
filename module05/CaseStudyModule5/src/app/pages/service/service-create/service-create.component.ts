import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ServiceService} from '../../../services/service.service';
import {IRentType} from '../../../models/IRentType';
import {IService} from '../../../models/IService';
import {Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {
  createForm: FormGroup;
  rentTypeList: IRentType[] = [];
  service: IService;

  constructor(private fb: FormBuilder, private serviceService: ServiceService,
              private router: Router, private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.serviceService.getAllRentType().subscribe(data => {
      this.rentTypeList = data;
      this.createForm = this.fb.group({
        id: [''],
        code: ['', Validators.required && Validators.pattern('^(DV-\\d{4})$')],
        name: ['', Validators.required && Validators.minLength(3)],
        area: ['', Validators.required && Validators.min(100)],
        floor: ['', Validators.required && Validators.min(1)],
        maxPeople: ['', Validators.required && Validators.min(1)],
        rentCost: ['', Validators.required && Validators.min(1)],
        status: ['', Validators.required],
        rentType: [this.rentTypeList[1].name, Validators.required],
      });
    });

  }

  createService() {
    this.service = this.createForm.value;
    this.serviceService.addService(this.service).subscribe(data => {
      this.router.navigateByUrl('/service');
    });
  }


  openSnackBar(message, action) {
    this.snackBar.open(message, action, {duration: 5000});
  }
}
