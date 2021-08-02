import {Component, NgModule} from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerComponent} from './pages/customer/customer.component';
import {EditComponent} from './pages/customer/edit/edit.component';


const routes: Routes = [
  {
    path: "",
    component: CustomerComponent
  },
  {
    path: "customer/add/:id",
    component: EditComponent
  },
  {
    path: "customer/edit/:id",
    component: EditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
