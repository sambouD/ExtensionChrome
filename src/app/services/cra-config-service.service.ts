import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AlertCraConfig } from '../models/alert-cra-config';

@Injectable({
  providedIn: 'root'
})
export class CraConfigServiceService {

  private craConfig: String;
  constructor(private http: HttpClient) { 
    this.craConfig = 'http://localhost:8080/config'

  }

  public addCraConfig(cra: AlertCraConfig){
      return this.http.post<AlertCraConfig>(`${this.craConfig}/saveTest`, cra);
  }
}
