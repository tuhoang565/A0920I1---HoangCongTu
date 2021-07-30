import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Article} from '../article/article.component';

@Component({
  selector: 'app-add-new',
  templateUrl: './add-new.component.html',
  styleUrls: ['./add-new.component.css']
})
export class AddNewComponent implements OnInit {
  @Input() articlesChild : Array<Article>;

  @Output() countChanged: EventEmitter<Array<Article>> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  addArticle(){
    let a = new Article();
    a.title = this.title;
    a.url = this.url;
    this.articlesChild.push(a);
    this.countChanged.emit(this.articlesChild);
  }
}
