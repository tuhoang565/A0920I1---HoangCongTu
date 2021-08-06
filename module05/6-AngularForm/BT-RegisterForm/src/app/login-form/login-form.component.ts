import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

export class User {
  email: string;
  password: string
}
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  loginForm: FormGroup;
  users: Array<User> = [
    {email: 'hello@gmail.com', password: '123456'},
    {email: 'byebye@gmail.com', password: '123456'},
    {email: 'goodnight@gmail.com', password: '123456'}
    ];

  constructor() { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.pattern('^[a-z][a-z0-9_\\.]{1,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$')]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
    })
  }

  onSubmit() {

  }

}
