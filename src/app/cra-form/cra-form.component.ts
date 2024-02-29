import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AlertCraConfig } from '../models/alert-cra-config';
import { CraConfigServiceService } from '../services/cra-config-service.service';

import * as moment from 'moment';

interface Period {
  name: string;

}

@Component({
  selector: 'app-cra-form',
  templateUrl: './cra-form.component.html',
  styleUrls: ['./cra-form.component.css']
})
export class CraFormComponent {

  craConfig: AlertCraConfig;

  perio: Period[] | undefined;


  constructor(private craservice: CraConfigServiceService) {
    this.craConfig = new AlertCraConfig();
  }
  ngOnInit() {
    this.perio = [
      { name: 'Matin' },
      { name: 'Soir' },

  ];

  }

  myForm = new FormGroup({
    date: new FormControl(),
    periode: new FormControl()
  })


  onSubmit(){
      
    const selectedDate: Date | null = this.myForm.value.date;
    if (selectedDate) {
      // Convertir la date en format ISO 8601
const isoDateString: string = moment(selectedDate).format('YYYY-MM-DDTHH:mm:ss.SSS');
   
      this.craConfig.date = isoDateString;
      this.craConfig.periode = this.myForm.value.periode?.name;
  
      this.craservice.addCraConfig(this.craConfig).subscribe(result => {
        console.log(result);
      });
    }

    }

  }


