import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../../../services/employee.service';
import {ActivatedRoute} from '@angular/router';
import {IEmployee} from '../../../models/IEmployee';
import {MatDialog} from '@angular/material/dialog';
import {EmployeeDeleteComponent} from '../employee-delete/employee-delete.component';
import {map} from 'rxjs/operators';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: IEmployee[] = [];
  employee: IEmployee;

  p: number = 1;
  key: string = 'id';
  reverse: boolean = false;

  constructor(private employeeService: EmployeeService, private route: ActivatedRoute,
              private dialog: MatDialog) { }

  ngOnInit(): void {
    this.showAllEmployee();
  }

  showAllEmployee(){
    this.employeeService.getAllEmployee().subscribe(data =>{
      this.employees = data;
    })
  }

  deleteEmployee(id: number, fullName: string) {
    // this.employeeService.findById(id).subscribe(data =>{
    //   this.employee = data;
    // });
    // console.log(this.employee);

    let dialogRef = this.dialog.open(EmployeeDeleteComponent, {data: {infor: fullName}});
    dialogRef.afterClosed().subscribe(result =>{
      // console.log(result);
      if(result) {
        this.employeeService.deleteEmployee(id);
        
      }
    })
  }

  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }
}
