import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PostService} from '../post.service';
import {error} from '@angular/compiler/src/util';
import {IPost} from '../post';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {
  postList: IPost[] = [];
  postForm: FormGroup;
  constructor(private postService: PostService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.postForm = this.fb.group({
      title: ['', [Validators.required, Validators.minLength(10)]],
      body: ['', [Validators.required, Validators.minLength(10)]]
    });
    // tslint:disable-next-line:no-shadowed-variable
    this.postService.getPosts().subscribe(next => (this.postList = next), error => (this.postList = []));
  }

  onSubmit() {
    if (this.postForm.valid){
      const {value} = this.postForm;
      this.postService.createPost(value).subscribe(next => {
        this.postList.unshift(next);
        this.postForm.reset({title: '', body: ''});
        // tslint:disable-next-line:no-shadowed-variable
      }, error => console.log(error));
    }
  }
  deletePost(i){
    const post = this.postList[i];
    this.postService.deletePost(post.id).subscribe(() => {
      this.postList = this.postList.filter(t => t.id !== post.id);
    });
  }
}
