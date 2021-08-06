import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {StudentServiceService} from '../service/student-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {IStudent} from '../models/IStudent';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  id: number;
  createForm: FormGroup;
  constructor(private router: Router, private studentService: StudentServiceService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = +this.activatedRoute.snapshot.paramMap.get('id');

    this.createForm = new FormGroup({
      id: new FormControl(''),
      name: new FormControl(''),
      age: new FormControl(''),
      mark: new FormControl('')
    });
  }

  onSubmit() {
    let student: IStudent = {
      id: this.createForm.get('id').value,
      name: this.createForm.get('name').value,
      age: this.createForm.get('age').value,
      mark: this.createForm.get('mark').value
    }
    this.studentService.onAdd(student);
    this.router.navigateByUrl('');
  }
}
