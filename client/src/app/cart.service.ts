import { Injectable } from '@angular/core';
import { CartItem } from './CartModel';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() { }

  private cartItems : CartItem[]=[];

  private CartSubject = new BehaviorSubject<CartItem[]>([]);

  cart$=this.CartSubject.asObservable();

  addToCart(book : any)
  {
    const existing = this.cartItems.find(item=>item.id === book.id);

    if(existing)
    {
      existing.quantity++;
    }
    else{
      this.cartItems.push({
        id : book.id,
        title : book.title,
        price : book.price,
        url : book.url,
        quantity : 1

      });
    }

    this.CartSubject.next(this.cartItems);
  }

  removeFromCart(id : number)
  {
    this.cartItems=this.cartItems.filter(item=>item.id!==id);
    this.CartSubject.next(this.cartItems);
  }

  clearCart()
  {
    this.cartItems = [];
    this.CartSubject.next(this.cartItems);
  }

  getTotalPrice() : number
  {
    return this.cartItems.reduce(
      (sum,item)=>sum+item.price*item.quantity,
      0
    );
  } 
}
