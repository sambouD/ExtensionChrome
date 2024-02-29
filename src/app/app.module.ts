import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';


import { CraFormComponent } from './cra-form/cra-form.component';

// PrimeNg
import { MenubarModule } from 'primeng/menubar';
import { CalendarModule } from 'primeng/calendar';
import { ButtonModule } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';
import { ReminderFormComponent } from './reminder-form/reminder-form.component';
import { InputTextModule } from 'primeng/inputtext';
import { PeriodictyFormComponent } from './periodicty-form/periodicty-form.component';
import { RadioButtonModule } from 'primeng/radiobutton';
import { CheckboxModule } from 'primeng/checkbox';





@NgModule({
  declarations: [
    AppComponent,
    CraFormComponent,
    ReminderFormComponent,
    PeriodictyFormComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    


    //primeNg

    MenubarModule,
    CalendarModule,
    ButtonModule,
    DropdownModule,
    InputTextModule,
    RadioButtonModule,
    CheckboxModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
