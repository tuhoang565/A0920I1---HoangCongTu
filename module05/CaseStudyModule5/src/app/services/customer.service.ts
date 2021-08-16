import { Injectable } from '@angular/core';
import {ICustomer} from '../models/ICustomer';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  URL = 'http://localhost:3000/customer';
  regURL = 'http://localhost:3000/customerType';



  constructor(private http: HttpClient) {}
  httpOptions = {
    header: new Headers({
      'Content-Type': 'application/json'
    })
  };

  getAllCustomerType(){
    return this.http.get(this.regURL);
  }
  getAllCustomer(): Observable<ICustomer[]>{
    return this.http.get(this.URL)
      .pipe(map((response: ICustomer[]) =>{
        return response;
      }))
  }
  createCustomer(data: ICustomer){
    return this.http.post<ICustomer>(this.URL, data)
      .pipe(map((response: ICustomer) =>{
        return response;
      }))
  }

  deleteCustomer(id: number){
    return this.http.delete<ICustomer>(this.URL + '/' + id)
      .pipe(map((response: ICustomer) =>{
        return response;
      }))
  }

  editCustomer(data: any, id: number){
    return this.http.put<ICustomer>(this.URL + '/' + id, data)
      .pipe(map((response:ICustomer) =>{
        return response;
      }))
  }

  findById(id: number){
    return this.http.get(this.URL + '/' + id);
  }

}
