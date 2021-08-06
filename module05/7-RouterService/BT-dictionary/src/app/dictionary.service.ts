import { Injectable } from '@angular/core';
export class Dictionary{
  id: number;
  eng: string;
  vie: string;
}
@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionaries: Array<Dictionary> = [
    {
      id: 1, eng: 'hello', vie: 'Xin chao'
    },
    {
      id: 2, eng: 'goodbye', vie: 'Tam biet'
    },
    {
      id: 1, eng: 'night', vie: 'Buoi toi'
    }
      ];
  constructor() { }
  getAllDictionary(){
    return this.dictionaries;
  }
  getDictionaryById(id: number){
    return this.dictionaries.find(dic => dic.id === id);
  }
}
