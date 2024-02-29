import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CraFormComponent } from './cra-form/cra-form.component';
import { PeriodictyFormComponent } from './periodicty-form/periodicty-form.component';
import { ReminderFormComponent } from './reminder-form/reminder-form.component';

const routes: Routes = [
  {path: 'addCraAlert', component: CraFormComponent},
  {path: 'addReminderAlert', component: ReminderFormComponent},
  {path: 'addPeriodiciteAlert', component: PeriodictyFormComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
}
