import { Component } from '@angular/core';
import { SimpleAlertService } from '../util/simple-alert/simple-alert.service';


@Component({
  selector: 'app-transferencia',
  templateUrl: './transferencia.component.html',
  styleUrls: ['./transferencia.component.css']
})
export class TransferenciaComponent {
opcoesUsuarios = ['João', 'Maria', 'Alfredo']

constructor(private service: SimpleAlertService){}

  transferir(){
      this.service.notificar('SUCESSO','ESSA PARADA É BOA!',0)
  }

}
