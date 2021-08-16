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
import {ServiceComponent} from './pages/service/service.component';
import {ServiceCreateComponent} from './pages/service/service-create/service-create.component';
import {ServiceEditComponent} from './pages/service/service-edit/service-edit.component';
import {ServiceDeleteComponent} from './pages/service/service-delete/service-delete.component';
import {ServiceListComponent} from './pages/service/service-list/service-list.component';


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
  },
  {
    path: 'service', component: ServiceComponent,
    children: [
      {path: 'add', component: ServiceCreateComponent},
      {path: 'edit/:id', component: ServiceEditComponent},
      {path: 'delete/:id', component: ServiceDeleteComponent},
      {path: '', component: ServiceListComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
