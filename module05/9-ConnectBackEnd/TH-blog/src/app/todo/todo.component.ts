import { Component, OnInit } from '@angular/core';
import {Todo} from '../todo';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TodoService} from '../todo.service';
import {error} from '@angular/compiler/src/util';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todoList: Todo[] = [];
  todoForm: FormGroup;
  constructor(private todoService: TodoService, private fb: FormBuilder) { }

  ngOnInit(): void {
  this.todoForm = this.fb.group({
    title: ['', [Validators.required]],
    content: ['', [Validators.required]]
  });
    // tslint:disable-next-line:no-shadowed-variable
  this.todoService.getTodo().subscribe(next => (this.todoList = next), error => (this.todoList = []));
  }

}
