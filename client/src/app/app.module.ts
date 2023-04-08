import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LayoutComponent } from './layout/layout.component';
import { HomeComponent } from './layout/home/home.component';
import { ExtratoComponent } from './layout/extrato/extrato.component';
import { TransferenciaComponent } from './layout/transferencia/transferencia.component';
import { TituloComponent } from './layout/util/titulo/titulo.component';
import { NavBarComponent } from './layout/nav-bar/nav-bar.component';
import { GraficoComponent } from './layout/util/grafico/grafico.component';
import { SimpleAlertComponent } from './layout/util/simple-alert/simple-alert.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LayoutComponent,
    HomeComponent,
    ExtratoComponent,
    TransferenciaComponent,
    TituloComponent,
    NavBarComponent,
    GraficoComponent,
    SimpleAlertComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
