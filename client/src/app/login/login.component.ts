import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Transfer } from '../Transfer';
import { APIServiceService } from '../apiservice.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,HttpClientModule,RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  LoginData = {Email:'',Password:'',Address : '',Phone:''};
  constructor(private route : Router,private api : APIServiceService){}
  
  private obj : Transfer = new Transfer();

  LoginChecking()
  {
    this.obj.Email=this.LoginData.Email;
    this.obj.Password=this.LoginData.Password;
  

    this.api.LoginCheck(this.obj).subscribe(
      (res : any)=>{
        console.log("Login Successfull",res);
        alert("Login Successfull");
        this.route.navigate(['/Home']); 
         
      },
      (err: any )=>
      {
        console.log(err);
        alert("Form was unable to submit .");
      }
    )
  }



}
