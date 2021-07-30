import {Component, Input, OnDestroy, OnInit} from '@angular/core';

@Component({
  selector: 'app-countdown',
  templateUrl: './countdown.component.html',
  styleUrls: ['./countdown.component.css']
})
export class CountdownComponent implements OnInit, OnDestroy {
private intervalId = 0;
message = '';
remainingTime: number;

@Input() seconds = 11;
  constructor() { }

  clearTimer(){
    clearInterval(this.intervalId);
  }

  ngOnInit(): void {
    this.reset();
    this.start();
  }

  ngOnDestroy(): void {
    this.clearTimer();
  }

  start(){
    this.countDown();
    if(this.remainingTime <= 0){
      this.remainingTime = this.seconds;
    }
  }

  stop(){
    this.clearTimer();
    this.message = 'Holding at ' + this.remainingTime + ' seconds';
  }

  reset(){
    this.clearTimer();
    this.remainingTime = this.seconds;
    this.message = 'Click start button to start the countdown';
  }

  private countDown(){
    this.clearTimer();
    this.intervalId = window.setInterval(() =>{
      this.remainingTime -= 1;
      if(this.remainingTime === 0 ){
        this.message = 'Blast off';
        this.clearTimer();
      }else {
        this.message = this.remainingTime + ' seconds and counting';
      }
    }, 1000);
  }
}
