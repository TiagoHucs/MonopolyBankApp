import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import { Chart } from 'chart.js';


@Component({
  selector: 'app-grafico',
  templateUrl: './grafico.component.html',
  styleUrls: ['./grafico.component.css']
})
export class GraficoComponent implements AfterViewInit{
  @ViewChild('webElementChart', {}) webElementChart!: ElementRef<HTMLCanvasElement>;


  ngAfterViewInit(): void {
     this.criaGrafico();
  }

  criaGrafico(){


    var xValues = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'];
    var yValues = [7,10,11,14,13,15];

    //xValues = this.lineGraph.labels;
    //yValues = this.lineGraph.dados;

    var yMax = Math.max(...yValues);
    
    
    new Chart("myChart", {
      type: "line",
      data: {
        labels: xValues,
        datasets: [{
          label: 'meu titulo',
          fill: false,
          lineTension: 0,
          backgroundColor: "rgba(85,201,255,1.0)",
          borderColor: "#DFFF00",
          data: yValues,
          //fontColor: 'white',
        }]
      },
      options: {
        legend: {
          display: true,
          labels: {
            fontColor: 'white',
          },
        },
        scales: {
          yAxes: [
            { ticks: 
              { min: Math.min(...yValues), max: Math.max(...yValues),   fontColor: "white"} 
            }
          ], 
          xAxes: [
            { ticks: 
              {fontColor: "white"} 
            }
          ],

        }
      }
    });

  }

}
