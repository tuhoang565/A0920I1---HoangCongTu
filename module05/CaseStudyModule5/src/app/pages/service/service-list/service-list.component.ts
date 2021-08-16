import { Component, OnInit } from '@angular/core';
import {ServiceService} from '../../../services/service.service';
import {IService} from '../../../models/IService';
import {IRentType} from '../../../models/IRentType';
import {MatDialog} from '@angular/material/dialog';
import {ServiceDeleteComponent} from '../service-delete/service-delete.component';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  serviceList: IService[] = [];
  rentTypeList: IRentType[] = [];
  serviceListSearch: IService[] = [];
  service: any;
  name: string = '';

  constructor(private serviceService: ServiceService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.showAllRentType();
    this.showAllService();
    this.showAllServiceSearch();
  }

  showAllService(){
    this.serviceService.getAllService().subscribe(data =>{
      this.serviceList = data;
    })
  }

  showAllRentType(){
    this.serviceService.getAllRentType().subscribe(data =>{
      this.rentTypeList = data;
    })
  }

  showAllServiceSearch(){
    this.serviceService.getAllService().subscribe(data =>{
      this.serviceListSearch = data;
    })
  }

  deleteService(id: number) {
    this.serviceService.getServiceById(id).subscribe(data =>{
      this.service = data;

      let dialogRef = this.dialog.open(ServiceDeleteComponent, {
        data: {dataService: this.service},
        autoFocus: false,
      });
      dialogRef.afterClosed().subscribe(result =>{
        if(result) {
          this.serviceService.deleteService(this.service.id).subscribe(data => {
            this.ngOnInit();
          })
        }
      })
    });

  }

  searchName() {
    this.serviceService.searchService(this.name).subscribe(data =>{
      this.serviceListSearch = data;
      console.log(this.serviceListSearch);
    })
  }

}
