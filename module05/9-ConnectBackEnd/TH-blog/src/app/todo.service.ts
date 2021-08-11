import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Todo} from './todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private readonly API_URL = '';
  constructor(private http: HttpClient) { }

  getTodo(count = 5): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.)
  }
}
