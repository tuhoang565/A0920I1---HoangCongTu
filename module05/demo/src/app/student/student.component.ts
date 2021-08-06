import { Component, OnInit } from '@angular/core';
import {IStudent} from '../models/IStudent';
import {StudentServiceService} from '../service/student-service.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  students: IStudent[];
  id: number;
  constructor(private studentService: StudentServiceService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.students = this.studentService.getAllStudent();
  }
  onDelete(id: number){
    this.studentService.onDelete(id);
  }
}
