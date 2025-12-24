import { Component, OnInit } from '@angular/core';
import { APIServiceService } from '../apiservice.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CartService } from '../cart.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-buying',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterLink],
  templateUrl: './buying.component.html',
  styleUrl: './buying.component.css'
})
export class BuyingComponent implements OnInit{
    Data : any[] =[];
    books : any[] =[];
    Search : string ='';

    constructor(private api : APIServiceService,private cart : CartService){}

    ngOnInit(): void {
        this.api.BuyingData().subscribe(
          (res : any[])=>{
            this.Data=res;
          },
          err => console.log(err)
        );
    }


    addtoCart(book : any)
    {
      this.cart.addToCart(book);
      alert('Book added to cart')
    }

    buyNow(book : any)
    {
      this.api.BuyNowService(book._id).subscribe({
        next:(res)=>{
          alert("Order Placed Successfully");
        },
      error : (err)=>{
          alert("Failed to place order ");
          console.log(err);
      }
    });
    }


    filterbooks()
    {
      const term = this.Search.toLowerCase().trim();

      if(!term)
      {
        this.books=this.Data
        return;
      }

      this.books=this.Data.filter(
          book=>
          book.title.toLowerCase().includes(term) ||
          book.description.toLowerCase().includes(term)
      );
    }
}
