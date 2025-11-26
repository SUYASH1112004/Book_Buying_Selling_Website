import { Component, OnInit } from '@angular/core';
import { APIServiceService } from '../apiservice.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{
    
  CardData : any[] = []
  constructor(private api : APIServiceService){}

  ngOnInit(): void {
      this.api.getCards().subscribe(res=>this.CardData=res,err=>console.log(err));
  }


}
