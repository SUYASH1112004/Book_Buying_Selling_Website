import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { Environment } from './Environment';
import { Observable, ObservableInput } from 'rxjs';
import { Transfer } from './Transfer';
import { SellingModel } from './SellingModel';

@Injectable({
  providedIn: 'root'
})
export class APIServiceService {

  constructor(private Http : HttpClient) { }

  private _cardURL = `${Environment.API_URL}/cards`;
  private _LoginURL = `${Environment.API_URL}/Login`;
  private _SignupURL =`${Environment.API_URL}/Signup`;
  private _BuyURL = `${Environment.API_URL}/Buying`;
  private _SellingURL = `${Environment.API_URL}/Selling`;
  

  getCards() : Observable<any[]>
  {
    return this.Http.get<any[]>(this._cardURL);
  }

  LoginCheck(data : Transfer)
  {
      return this.Http.post<any>(this._LoginURL,data);
  }

  SignUP(data : Transfer)
  {
    return this.Http.post<any>(this._SignupURL,data);
  }

  Buying():Observable<any[]>
  {
    return this.Http.get<any[]>(this._BuyURL);
  }


  Selling(data : SellingModel)
  {
    return this.Http.post<any[]>(this._SellingURL,data);
  }
}
