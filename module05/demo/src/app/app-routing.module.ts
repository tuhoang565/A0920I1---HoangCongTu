import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StudentComponent} from './student/student.component';
import {StudentDeleteComponent} from './student-delete/student-delete.component';
import {StudentEditComponent} from './student-edit/student-edit.component';
import {StudentCreateComponent} from './student-create/student-create.component';


const routes: Routes = [
  {path:'', component: StudentComponent},
  {path:'edit/:id', component: StudentEditComponent},
  {path:'add', component: StudentCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
