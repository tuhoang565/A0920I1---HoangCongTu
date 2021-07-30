import { Component, OnInit } from '@angular/core';
import {IStudent} from '../models/IStudent';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  students: IStudent[] = studentDao;
  constructor() { }

  ngOnInit(): void {
  }

  getAllStudent(){

  }
}
