import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import {HeaderComponent} from "./common/components/header/header.component";
import {BasicLayoutComponent} from "./layouts/basic-layout/basic-layout.component";
import {LoginComponent} from "./pages/login/login.component";
import {RegisterComponent} from "./pages/register/register.component";

const routes: Routes = [
  { path: '', component: HeaderComponent, children: [
      {path: 'home', component: HomeComponent},
      {path: '', redirectTo: '/home', pathMatch: 'full' }
    ]
  },
  {
    path: '', component: BasicLayoutComponent, children: [
      {path: 'login', component: LoginComponent},
      {path: 'register', component: RegisterComponent}
    ]
  },
  {path: '**', redirectTo: 'home'}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]

})
export class AppRoutingModule { }
