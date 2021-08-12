import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {IEmployee} from '../models/IEmployee';
import {IDivision} from '../models/IDivision';
import {Observable, pipe} from 'rxjs';
import {map} from 'rxjs/operators';
import {IPosition} from '../models/IPosition';
import {IEducationDegree} from '../models/IEducationDegree';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  employeeURL = 'http://localhost:3000/employee';
  divisionURL = 'http://localhost:3000/division';
  positionURL = 'http://localhost:3000/position';
  eduURL = 'http://localhost:3000/educationDegree';

  constructor(private http: HttpClient) { }

  getAllDivision(): Observable<IDivision[]>{
    return this.http.get<IDivision[]>(this.divisionURL)
      .pipe(map((response: IDivision[]) =>{
        return response;
      }))
  }
  getAllPosition(): Observable<IPosition[]>{
    return this.http.get<IPosition[]>(this.positionURL)
      .pipe(map((response:IPosition[]) =>{
        return response;
      }));
  }
  getAllEducationDegree(): Observable<IEducationDegree[]>{
    return this.http.get<IEducationDegree[]>(this.eduURL)
      .pipe(map((response: IEducationDegree[]) =>{
        return response;
      }));
  }
  getAllEmployee(): Observable<IEmployee[]>{
    return this.http.get<IEmployee[]>(this.employeeURL)
      .pipe(map((response: IEmployee[]) =>{
        return response;
      }));
  }
  createEmployee(data: IEmployee){
    return this.http.post<IEmployee>(this.employeeURL, data);
  }

  findById(id: number){
    return this.http.get(`${this.employeeURL}/${id}`)
      // .pipe(map((response: IEmployee)=>{
      //   return response;
      // }));
  }

  editEmployee(data: IEmployee, id: number){
    return this.http.put(this.employeeURL + '/' + id, data);
  }

  deleteEmployee(id: number){
    return this.http.delete(this.employeeURL + '/' + id);
  }
}
