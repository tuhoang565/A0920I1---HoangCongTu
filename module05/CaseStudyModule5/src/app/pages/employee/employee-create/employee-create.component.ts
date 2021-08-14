import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {IPosition} from '../../../models/IPosition';
import {IEducationDegree} from '../../../models/IEducationDegree';
import {IDivision} from '../../../models/IDivision';
import {EmployeeService} from '../../../services/employee.service';
import {IEmployee} from '../../../models/IEmployee';
import {Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';
import {style} from '@angular/animations';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  createForm: FormGroup;
  divisionList: IDivision[] = [];
  positionList: IPosition[] = [];
  educationDegreeList: IEducationDegree[] = [];
  employee: IEmployee;
  minDate = new Date(1900, 1, 1);
  maxDate = new Date();

  constructor(private fb: FormBuilder, private employeeService: EmployeeService,
              private router: Router, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getAllDivisionList();
    this.getAllPositionList();
    this.getAllEducationDegreeList();

    this.createForm = this.fb.group({
      id: [''],
      employeeCode: ['', Validators.required && Validators.pattern('^(NV-\\d{4})$')],
      fullName: ['', Validators.required],
      position: ['', Validators.required],
      educationDegree: ['', Validators.required],
      division: ['', Validators.required],
      birthday: ['', Validators.required],
      idCard: ['', Validators.required && Validators.pattern('^(\\d{9}|\\d{12})$')],
      salary: ['', Validators.required && Validators.min(1)],
      phoneNumber: ['', Validators.required && Validators.pattern('^((090|091)\\d{7})$')],
      email: ['', Validators.required && Validators.pattern('^[a-z][a-z0-9_\\.]{1,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$')],
      address: ['', Validators.required],
    });
  }

  getAllDivisionList(){
    this.employeeService.getAllDivision().subscribe(data =>{
      this.divisionList = data;
    });
  }

  getAllPositionList(){
    this.employeeService.getAllPosition().subscribe(data =>{
      this.positionList = data;
    })
  }

  getAllEducationDegreeList(){
    this.employeeService.getAllEducationDegree().subscribe(data =>{
      this.educationDegreeList = data;
    })
  }

  createEmployee(){
    this.employee = this.createForm.value;
    this.employeeService.createEmployee(this.employee).subscribe(data =>{
      this.router.navigateByUrl('employee')
    }, error => {
      console.log('create error');
    })
  }

  openSnackBar(message, action) {
    this.snackBar.open(message, action, {duration: 3000});
  }
}
