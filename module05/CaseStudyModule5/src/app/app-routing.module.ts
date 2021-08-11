import {Component, NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CustomerComponent} from './pages/customer/customer.component';
import {EditComponent} from './pages/customer/edit/edit.component';
import {CustomerCreateComponent} from './pages/customer/customer-create/customer-create.component';
import {CustomerDeleteComponent} from './pages/customer/customer-delete/customer-delete.component';
import {EmployeeComponent} from './pages/employee/employee.component';


const routes: Routes = [
  {
    path: 'customer', component: CustomerComponent
  },
  {
    path: "customer/add",
    component: CustomerCreateComponent
  },
  {
    path: 'customer/edit/:id',
    component: EditComponent
  },
  {
    path: 'customer/delete/:id',
    component: CustomerDeleteComponent
  },
  {
    path: 'customer/search/:searchText',
    component: CustomerComponent
  },
  {
    path: 'employee', component: EmployeeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
