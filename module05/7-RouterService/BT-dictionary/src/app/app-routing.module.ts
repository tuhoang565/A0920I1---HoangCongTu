import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionaryDetailComponent} from './dictionary-detail/dictionary-detail.component';
import {DictionaryPageComponent} from './dictionary-page/dictionary-page.component';
import {DictionaryComponent} from './dictionary/dictionary.component';


const routes: Routes = [
  {path: '', component: DictionaryPageComponent},
  {path: 'dictionary-detail/:id', component: DictionaryDetailComponent},
  {path: 'dictionary/:eng', component: DictionaryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
