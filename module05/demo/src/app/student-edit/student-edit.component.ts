import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {StudentServiceService} from '../service/student-service.service';
import {FormControl, FormGroup} from '@angular/forms';
import {IStudent} from '../models/IStudent';

@Component({
  selector: 'app-student-edit',
  templateUrl: './student-edit.component.html',
  styleUrls: ['./student-edit.component.css']
})
export class StudentEditComponent implements OnInit {
  id: number;
  name: string;
  age: number;
  mark: number;

  editForm: FormGroup;
  student: IStudent;
  constructor(private activatedRoute: ActivatedRoute, private studentService: StudentServiceService) { }

  ngOnInit(): void {
    this.id = +this.activatedRoute.snapshot.paramMap.get('id');


    this.editForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl(),
      age: new FormControl(),
      mark: new FormControl()
    });
  }

  onSubmit() {

  }

  getStudent(id: number){
    console.log(this.studentService.getStudentById(id));

}
}
