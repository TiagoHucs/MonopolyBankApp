import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { SimpleAlert } from './simple-alert';

@Injectable({
  providedIn: 'root'
})
export class SimpleAlertService {

  componentExecute = new Subject<SimpleAlert>();

  notificar(title: string, text: string, code: number) {
    this.componentExecute.next(
      new SimpleAlert(title,text,code)
    );
  }
  
}
