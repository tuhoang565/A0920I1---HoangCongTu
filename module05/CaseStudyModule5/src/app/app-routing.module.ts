import {Component, NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CustomerComponent} from './pages/customer/customer.component';
import {EditComponent} from './pages/customer/edit/edit.component';
import {CustomerCreateComponent} from './pages/customer/customer-create/customer-create.component';
import {CustomerDeleteComponent} from './pages/customer/customer-delete/customer-delete.component';
import {EmployeeComponent} from './pages/employee/employee.component';
import {EmployeeCreateComponent} from './pages/employee/employee-create/employee-create.component';
import {EmployeeEditComponent} from './pages/employee/employee-edit/employee-edit.component';
import {EmployeeDeleteComponent} from './pages/employee/employee-delete/employee-delete.component';
import {EmployeeListComponent} from './pages/employee/employee-list/employee-list.component';


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
    path: 'employee', component: EmployeeComponent,
    children: [
      {path: 'add', component: EmployeeCreateComponent},
      {path: 'edit/:id', component: EmployeeEditComponent},
      {path: 'delete/:id', component: EmployeeDeleteComponent},
      {path: '', component: EmployeeListComponent},
      ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
