import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../../../services/employee.service';
import {ActivatedRoute} from '@angular/router';
import {IEmployee} from '../../../models/IEmployee';
import {MatDialog} from '@angular/material/dialog';
import {EmployeeDeleteComponent} from '../employee-delete/employee-delete.component';
import {map} from 'rxjs/operators';
import {IDivision} from '../../../models/IDivision';
import {IPosition} from '../../../models/IPosition';
import {IEducationDegree} from '../../../models/IEducationDegree';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: IEmployee[] = [];
  employee: IEmployee;
  divisionList: IDivision[] = [];
  divisionName: string = '';
  positionList: IPosition[] = [];
  positionName: string = '';
  eduList: IEducationDegree[] = [];
  eduId: number;
  salary: string = '';
  fullName: string;

  page: number = 1;
  key: string = 'id';
  reverse: boolean = false;

  constructor(private employeeService: EmployeeService, private route: ActivatedRoute,
              private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.showAllEmployee();
    this.showDivisionList();
    this.showPositionList();
  }

  showAllEmployee() {
    this.employeeService.getAllEmployee().subscribe(data => {
      this.employees = data;
    });
  }

  deleteEmployee(id: number, fullName: string) {
    // this.employeeService.findById(id).subscribe(data =>{
    //   this.employee = data;
    // });
    // console.log(this.employee);

    let dialogRef = this.dialog.open(EmployeeDeleteComponent, {data: {infor: fullName}});
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.employeeService.deleteEmployee(id).subscribe(data => {
          this.ngOnInit();
        });
      }
    });
  }

  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }

  searchName() {
    if (this.fullName === "") {
      this.ngOnInit();
    } else {
      this.employeeService.searchByName(this.fullName).subscribe((data:IEmployee[]) =>{
        this.employees = data;
        this.page = 1;
      })
    }
  }

  showDivisionList(){
    this.employeeService.getAllDivision().subscribe(data =>{
      this.divisionList = data;
    })
  }

  showPositionList(){
    this.employeeService.getAllPosition().subscribe(data =>{
      this.positionList = data;
    })
  }

  search() {
    this.employeeService.searchBy(this.divisionName, this.positionName, this.salary).subscribe((data:IEmployee[]) =>{
      this.employees = data;
      this.page = 1;
    });
  }

  // searchSalary(){
  //   this.employeeService.searchRange(this.salary).subscribe((data: IEmployee[]) =>{
  //     this.employees = data;
  //     this.page = 1;
  //   })
  // }
}
