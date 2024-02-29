import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Reminder } from '../models/reminder';
import { ReminderServiceService } from '../services/reminder-service.service';

import * as moment from 'moment';

@Component({
  selector: 'app-reminder-form',
  templateUrl: './reminder-form.component.html',
  styleUrls: ['./reminder-form.component.css']
})
export class ReminderFormComponent {

  reminder: Reminder

  constructor(private reminderservice: ReminderServiceService) {
    this.reminder = new Reminder();
  }
  ngOnInit() {


  }
  
  myForm = new FormGroup({
    date: new FormControl(),
    text: new FormControl()
  })

  onSubmit(){

    this.reminder.date = this.myForm.value.date;
      this.reminder.text = this.myForm.value.text;
  
      this.reminderservice.addReminder(this.reminder).subscribe(result => {
        console.log(result);
      });
    }

  


}
