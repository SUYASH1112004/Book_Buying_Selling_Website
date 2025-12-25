import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';
import { Cardtdto } from '../home/CardDto';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent implements OnInit{


  cartItems : any[] =[];
  total = 0;

  constructor(private cart : CartService ){}

  ngOnInit(): void {
    this.cart.cart$.subscribe(
      items=>{
      this.cartItems=items;
      this.total=this.cart.getTotalPrice();
    }
    );
  }

  remove(id : number)
  {
    this.cart.removeFromCart(id);
  }

  placeOrder()
  {
    alert("Order Placed Successfully");
    this.cart.clearCart();
  }

}
