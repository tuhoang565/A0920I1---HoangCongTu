import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IService} from '../models/IService';
import {IRentType} from '../models/IRentType';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  serviceURL = 'http://localhost:3000/service';
  rentTypeURL = 'http://localhost:3000/rentType';

  constructor(private http: HttpClient) { }

  getAllRentType(): Observable<IRentType[]>{
    return this.http.get<IRentType[]>(this.rentTypeURL);
  }

  getAllService(): Observable<IService[]>{
    return this.http.get<IService[]>(this.serviceURL);
  }

  addService(service: IService){
    return this.http.post(this.serviceURL, service);
  }

  getServiceById(id: number){
    return this.http.get(this.serviceURL + '/' + id);
  }

  editService(id: number, data: IService){
    return this.http.put(this.serviceURL + '/' + id, data);
  }

  deleteService(id: number){
    return this.http.delete(this.serviceURL + '/' + id);
  }

  searchService(name: string){
    return this.http.get<IService[]>(this.serviceURL + '?name_like=' + name);
  }
}
