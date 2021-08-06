import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DictionaryComponent } from './dictionary/dictionary.component';
import { DictionaryDetailComponent } from './dictionary-detail/dictionary-detail.component';
import { DictionaryPageComponent } from './dictionary-page/dictionary-page.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    DictionaryComponent,
    DictionaryDetailComponent,
    DictionaryPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
