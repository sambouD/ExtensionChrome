import { Component } from '@angular/core';

import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'extensionChrome';
  items!: MenuItem[];

  
  ngOnInit() {
    this.items = [

        {
          label:'AlertCra',
          icon:'pi pi-play',
          routerLink: '/addCraAlert'
          
        },
        {
          label:'ReminderCra',
          icon:'pi pi-history',
          routerLink: '/addReminderAlert',
      
        },
        {
          label:'PeriodiciteCra',
          icon:'pi pi-history',
          routerLink: '/addPeriodiciteAlert',
      
        },
    ];
} 
}
