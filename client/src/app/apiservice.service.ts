import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { Environment } from './Environment';
import { Observable, ObservableInput } from 'rxjs';
import { Transfer } from './Transfer';
import { SellingModel } from './SellingModel';
import { Cardtdto } from './CardDto';

@Injectable({
  providedIn: 'root'
})
export class APIServiceService {

  constructor(private Http : HttpClient) { }

  private _cardURL = `${Environment.API_URL}/cards`;
  private _LoginURL = `${Environment.API_URL}/login`;
  private _SignupURL =`${Environment.API_URL}/signup`;
  private _BuyURL = `${Environment.API_URL}/buying`;
  private _SellingURL = `${Environment.API_URL}/selling`;
  private _buyNow=`${Environment.API_URL}/buynow`;
  

  getCards() : Observable<any[]>
  {
    return this.Http.get<Cardtdto[]>(this._cardURL);
  }

  LoginCheck(data : Transfer)
  {
      return this.Http.post<any>(this._LoginURL,data);
  }

  SignUP(data : Transfer)
  {
    return this.Http.post<any>(this._SignupURL,data);
  }

  BuyingData():Observable<any[]>
  {
    return this.Http.get<any[]>(this._BuyURL);
  }

  BuyNowService(id :String)
  {
    return this.Http.post<any>(this._buyNow,id);
  }

  Selling(data : SellingModel)
  {
    return this.Http.post<any[]>(this._SellingURL,data);
  }
}
