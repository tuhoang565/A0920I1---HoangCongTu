import { Injectable } from '@angular/core';
import {IStudent} from '../models/IStudent';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {
  students: Array<IStudent> = [
    {
      id: 1, name: "Tu Hoang", age: 20, mark: 3
    },
    {
      id: 2, name: "Hoang Long", age: 20, mark: 5
    },
    {
      id: 3, name: "Van Phong", age: 20, mark: 7
    },
    {
      id: 4, name: "Anh Nguyet", age: 20, mark: 8
    },
    {
      id: 5, name: "Nhu Y", age: 20, mark: 2
    }
  ];
  private id: number;
  constructor() { }

  getAllStudent(){
    return this.students;
  }

  onAdd(student: IStudent){
    this.students.push(student);
  }

  getStudentById(id: number){
    return this.students.find(student => this.id === id)
  }

  onDelete(id: number) {
    let student = this.students.find(x => x.id === id);
    let index = this.students.indexOf(student, 0);
    this.students.splice(index, 1);
  }
}
