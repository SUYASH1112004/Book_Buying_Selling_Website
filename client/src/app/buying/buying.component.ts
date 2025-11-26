import { Component, OnInit } from '@angular/core';
import { APIServiceService } from '../apiservice.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-buying',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './buying.component.html',
  styleUrl: './buying.component.css'
})
export class BuyingComponent implements OnInit{
    Data : any[] =[];
    books : any[] =[];
    Search : string ='';

    constructor(private api : APIServiceService){}

    ngOnInit(): void {
        this.api.Buying().subscribe(
          (res : any[])=>{
            this.Data=res;
          },
          err => console.log(err)
        );
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
