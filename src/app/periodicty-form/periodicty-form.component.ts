import { Component } from '@angular/core';

@Component({
  selector: 'app-periodicty-form',
  templateUrl: './periodicty-form.component.html',
  styleUrls: ['./periodicty-form.component.css']
})
export class PeriodictyFormComponent {
  selectedCategory: any = null;

  date!: Date;


selectedDays: string[] = [];

  categories: any[] = [
      { name: 'Quotidienne', key: 'Q' },
      { name: 'Hebdomadaire', key: 'H' },
      { name: 'Mensuelle', key: 'M' },
      { name: 'Annuelle', key: 'A' }
  ];



  days: any[] = [
      { name: 'Lundi', key: 'L' },
      { name: 'Mardi', key: 'M' },
      { name: 'Mercredi', key: 'MER' },
      { name: 'Jeudi', key: 'J' },
      { name: 'Vendredi', key: 'V' }
  ];


  ngOnInit() {
      this.selectedCategory = this.categories[1];
  }



}
