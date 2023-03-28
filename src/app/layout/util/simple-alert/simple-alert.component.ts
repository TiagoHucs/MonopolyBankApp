import { Component } from '@angular/core';
import { SimpleAlertService } from './simple-alert.service';

@Component({
  selector: 'app-simple-alert',
  templateUrl: './simple-alert.component.html',
  styleUrls: ['./simple-alert.component.css']
})
export class SimpleAlertComponent {

  constructor(private service: SimpleAlertService) {}

  ngOnInit() {
    this.service.componentExecute.subscribe((data) => {
      this.notificar(data.text, data.text, data.code);
    });
  }

  notificar(title: string, text: string, code: number) {

    const alertElement = document.createElement("div");

    alertElement.classList.add("sp-alert");
    alertElement.classList.add(code == 0 ? "sp-alert-success" : "sp-alert-error")
    alertElement.innerHTML = `<strong>${title}!</strong> ${text}`;

    document.body.appendChild(alertElement);

    setTimeout(() => {
      alertElement.classList.add("sp-show");
    }, 100);

    setTimeout(() => {
      alertElement.classList.remove("sp-show");
      alertElement.classList.add("sp-exit");

      setTimeout(() => {
        document.body.removeChild(alertElement);
      }, 500);
    }, 3000);
  }

}
