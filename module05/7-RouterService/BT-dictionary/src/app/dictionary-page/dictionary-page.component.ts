import { Component, OnInit } from '@angular/core';
import {Dictionary, DictionaryService} from '../dictionary.service';

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  dictionary: Dictionary;
  eng: string;
  dictionaries: Dictionary[] = this.dictionaryService.getAllDictionary();
  constructor(private dictionaryService: DictionaryService) { }

  ngOnInit(): void {
  }
  search(){
    this.dictionaries = this.dictionaries.filter(dic => {
      return dic.eng.toLocaleLowerCase().match(this.eng.toLocaleLowerCase());
    });
  }
}
