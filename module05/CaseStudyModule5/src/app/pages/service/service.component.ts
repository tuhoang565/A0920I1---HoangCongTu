import { Component, OnInit } from '@angular/core';
import {ServiceService} from '../../services/service.service';
import {HttpClient} from '@angular/common/http';
import {IService} from '../../models/IService';
import {IRentType} from '../../models/IRentType';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {


  constructor(private serviceService: ServiceService, private http: HttpClient) { }

  ngOnInit(): void {

  }


}
