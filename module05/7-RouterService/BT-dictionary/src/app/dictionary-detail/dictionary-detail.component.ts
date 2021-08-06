import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Dictionary, DictionaryService} from '../dictionary.service';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  dic: Dictionary;
  constructor(private activatedRoute: ActivatedRoute, private dictionaryService: DictionaryService, private router: Router) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      // tslint:disable-next-line:radix
      return this.dic = this.dictionaryService.getDictionaryById(parseInt(paramMap.get('id')));
    });
  }

}
