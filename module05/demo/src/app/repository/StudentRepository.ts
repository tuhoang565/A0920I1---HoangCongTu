import {IStudent} from '../models/IStudent';


export class StudentRepository{
  studentDao: Array<IStudent> = [
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
}
