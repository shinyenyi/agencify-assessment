import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PhonenumbersComponent } from './phonenumbers/phonenumbers.component';

const routes: Routes = [
  {
    path: '', redirectTo: 'phonenumbers', pathMatch: 'full'
  },
  {
    path: 'phonenumbers',
    component: PhonenumbersComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
