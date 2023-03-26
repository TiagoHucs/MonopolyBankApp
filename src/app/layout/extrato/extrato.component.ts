import { Component } from '@angular/core';

@Component({
  selector: 'app-extrato',
  templateUrl: './extrato.component.html',
  styleUrls: ['./extrato.component.css']
})
export class ExtratoComponent {
  operacoes: any = [
    {dataHora: '13:30', usuario: 'João', tipo: 'credito',valor: 1503.42},
    {dataHora: '13:35', usuario: 'Maria', tipo: 'débito',valor: 803.42},
    {dataHora: '13:40', usuario: 'Alfredo', tipo: 'débito',valor: 53.12},
  ]
}
