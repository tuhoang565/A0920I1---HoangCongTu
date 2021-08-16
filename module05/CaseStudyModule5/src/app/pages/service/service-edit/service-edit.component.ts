import { Component, OnInit } from '@angular/core';
import {IRentType} from '../../../models/IRentType';
import {ServiceService} from '../../../services/service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {IService} from '../../../models/IService';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-service-edit',
  templateUrl: './service-edit.component.html',
  styleUrls: ['./service-edit.component.css']
})
export class ServiceEditComponent implements OnInit {
  rentTypeList: IRentType[] = [];
  id: number;
  service: IService;

  editForm = this.fb.group({
    id: [''],
    code: ['', Validators.required && Validators.pattern('^(DV-\\d{4})$')],
    name: ['', Validators.required && Validators.minLength(3)],
    area: ['', Validators.required && Validators.min(100)],
    floor: ['', Validators.required && Validators.min(1)],
    maxPeople: ['', Validators.required && Validators.min(1)],
    rentCost: ['', Validators.required && Validators.min(1)],
    status: ['', Validators.required],
    rentType: ['', Validators.required],
  });

  constructor(private serviceService: ServiceService, private router: Router,
              private activatedRoute: ActivatedRoute, private fb: FormBuilder,
              private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params.id;
    this.serviceService.getAllRentType().subscribe(data =>{
      this.rentTypeList = data;

      this.serviceService.getServiceById(this.id).subscribe(data =>{
        this.editForm.setValue(data);
      })
    });

  }


  editService() {
    this.service = this.editForm.value;
    this.serviceService.editService(this.id, this.service).subscribe(data =>{
      this.router.navigateByUrl('service');
    })

  }

  openEditSnackBar(message, action) {
    this.snackBar.open(message, action, {duration: 5000});
  }
}
