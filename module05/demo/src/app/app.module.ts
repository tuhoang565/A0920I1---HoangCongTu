import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentComponent } from './student/student.component';
import { StudentDeleteComponent } from './student-delete/student-delete.component';
import { StudentEditComponent } from './student-edit/student-edit.component';
import { StudentCreateComponent } from './student-create/student-create.component';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    StudentDeleteComponent,
    StudentEditComponent,
    StudentCreateComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
