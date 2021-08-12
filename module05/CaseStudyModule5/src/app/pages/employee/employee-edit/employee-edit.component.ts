import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../../services/employee.service';
import {ActivatedRoute, Router} from '@angular/router';
import {IDivision} from '../../../models/IDivision';
import {IPosition} from '../../../models/IPosition';
import {IEducationDegree} from '../../../models/IEducationDegree';
import {IEmployee} from '../../../models/IEmployee';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  editForm: FormGroup;
  id: number;
  divisionList: IDivision[];
  positionList: IPosition[];
  educationDegreeList: IEducationDegree[];
  employee: IEmployee;
  minDate = new Date(1900, 1, 1);
  maxDate = new Date();

  constructor(private fb: FormBuilder, private employeeService: EmployeeService,
              private route: ActivatedRoute, private snackBar: MatSnackBar,
              private router: Router) { }

  ngOnInit(): void {
    this.getDivisionList();
    this.getEducationDegreeList();
    this.getPositionList();

    this.editForm = this.fb.group({
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
      address: ['', Validators.required]
    });

    this.id = this.route.snapshot.params.id;
    this.employeeService.findById(this.id).subscribe(data =>{
      this.editForm.setValue(data);
    })
  }

  getDivisionList(){
    this.employeeService.getAllDivision().subscribe(data =>{
      this.divisionList = data;
    })
  }

  getPositionList(){
    this.employeeService.getAllPosition().subscribe(data =>{
      this.positionList = data;
    })
  }

  getEducationDegreeList(){
    this.employeeService.getAllEducationDegree().subscribe(data =>{
      this.educationDegreeList = data;
    })
  }

  editEmployee(){
    this.employee = this.editForm.value;
    this.employeeService.editEmployee(this.employee, this.id).subscribe(data =>{
      this.router.navigateByUrl('employee');
    });

  }

  openSnackBar(message, action){
    this.snackBar.open(message, action, {duration: 5000});
  }
}
