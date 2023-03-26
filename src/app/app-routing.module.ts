import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExtratoComponent } from './layout/extrato/extrato.component';
import { HomeComponent } from './layout/home/home.component';
import { LayoutComponent } from './layout/layout.component';
import { TransferenciaComponent } from './layout/transferencia/transferencia.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'prefix' },
  { path: 'login', component: LoginComponent },
  { path: 'layout', component: LayoutComponent,
    children: [
      { path: '', redirectTo: 'home', pathMatch: 'prefix' },
      { path: 'home', component: HomeComponent },
      { path: 'extrato', component: ExtratoComponent },
      { path: 'transferencia', component: TransferenciaComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
