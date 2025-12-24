import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Transfer } from '../Transfer';
import { APIServiceService } from '../apiservice.service';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [RouterLink,FormsModule,HttpClientModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {


    constructor(private route : Router,private api : APIServiceService){}

    obj : Transfer = new Transfer();

    Data = {Email :'',Password:'',Phone:'',Address:''};


    SignUpCheck()
    {
      this.obj.Email=this.Data.Email;
      this.obj.Password=this.Data.Password;
      this.obj.Address=this.Data.Address;
      this.obj.phone=this.Data.Phone;

      this.api.SignUP(this.obj).subscribe(
        (res:any)=>{
          console.log("Signup Successfull");
          alert("Signup Successfull");
          this.route.navigate(['/Login']);
        },
        (err : any)=>{
          console.log(err);
          alert("Unable to Signup");

        }
      )
      

    }

}
