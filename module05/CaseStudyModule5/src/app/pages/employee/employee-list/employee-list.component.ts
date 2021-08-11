import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../../../services/employee.service';
import {ActivatedRoute} from '@angular/router';
import {IEmployee} from '../../../models/IEmployee';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: IEmployee[] = [];
  constructor(private employeeService: EmployeeService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.showAllEmployee();
  }

  showAllEmployee(){
    this.employeeService.getAllEmployee().subscribe(data =>{
      this.employees = data;
    })
  }
}
