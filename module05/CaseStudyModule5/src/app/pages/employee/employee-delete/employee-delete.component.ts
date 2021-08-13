import { Component, OnInit, Inject } from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styleUrls: ['./employee-delete.component.css']
})
export class EmployeeDeleteComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  openSnackBar(message, action) {
    this.snackBar.open(message, action, {duration: 5000});
  }
}
