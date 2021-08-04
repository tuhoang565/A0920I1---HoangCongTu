import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators} from '@angular/forms';

function comparePassword(c: AbstractControl) {
  const v = c.value;
  return (v.password === v.confirmPassword) ? null : {
    passwordnotmatch: true
  };
}

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {
  registerForm: FormGroup;

  // comparePassword: ValidatorFn = (passwordGroup: AbstractControl): ValidationErrors|null =>{
  //   let password = passwordGroup.get('password').value;
  //   let confirmPassword = passwordGroup.get('confirmPassword').value;
  //   return password === confirmPassword ? null : {notSame: true}
  // };

  constructor() {
  }

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.pattern('^[a-z][a-z0-9_\\.]{1,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$')]),
      passwordGroup: new FormGroup({
        password: new FormControl(''),
        confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)])
      }, {validators: comparePassword}),
      country: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required, Validators.min(18)]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')])
    });
  }

  onSubmit() {
    console.log(this.registerForm.value);
  }


}

