import { Component } from '@angular/core';
import { notificar } from '../util/simple-alert';


@Component({
  selector: 'app-transferencia',
  templateUrl: './transferencia.component.html',
  styleUrls: ['./transferencia.component.css']
})
export class TransferenciaComponent {
opcoesUsuarios = ['João', 'Maria', 'Alfredo']

constructor(){}

  transferir(){
    notificar('sucesso','Transferencia realizada com sucesso',0);
  }

}
