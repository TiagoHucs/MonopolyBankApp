import { Component } from '@angular/core';
import { SimpleAlertService } from '../util/simple-alert/simple-alert.service';

@Component({
  selector: 'app-extrato',
  templateUrl: './extrato.component.html',
  styleUrls: ['./extrato.component.css']
})
export class ExtratoComponent {

  constructor(private simpleAlertService: SimpleAlertService){}


  operacoes: any = [
    {dataHora: '13:30', usuario: 'João', tipo: 'credito',valor: 1503.42},
    {dataHora: '13:35', usuario: 'Maria', tipo: 'débito',valor: 803.42},
    {dataHora: '13:40', usuario: 'Alfredo', tipo: 'débito',valor: 53.12},
  ]

  testar(){
    this.simpleAlertService.notificar('Sucesso', 'valor que eu qero emitir',0);
  }
}
