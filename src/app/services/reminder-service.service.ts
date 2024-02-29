import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reminder } from '../models/reminder';

@Injectable({
  providedIn: 'root'
})
export class ReminderServiceService {

  private reminder: String;
  constructor(private http: HttpClient) { 
    this.reminder = 'http://localhost:8080/config'

  }

  public addReminder(rem: Reminder){
      return this.http.post<Reminder>(`${this.reminder}/saveTestReminder`, rem);
  }
}
