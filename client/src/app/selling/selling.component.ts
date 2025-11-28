import { Component } from '@angular/core';
import { APIServiceService } from '../apiservice.service';
import { SellingModel } from '../SellingModel';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-selling',
  standalone: true,
  imports: [FormsModule,FormsModule],
  templateUrl: './selling.component.html',
  styleUrl: './selling.component.css'
})
export class SellingComponent {

  constructor(private Api : APIServiceService){}

  bookData ={title:'',author:'',price:'',description:''}

  obj : SellingModel = new SellingModel();
  imagePreview : string | ArrayBuffer | null = null;
  errorMessage : string = '';
  

  onImageSelected(event : any)
  {
    const file:File = event.target.files[0];

    if(!file)
    { alert("No Image added");
      return;
    }
    
    if(file && file.size> 10*1024*1024)
    {
      alert("Image size must be less than 10MB");
      this.obj.image=null;
      return;
    }

    if(!['image.png','image/jpeg','image/jpg'].includes(file.type))
    {
      alert("Only JPEG,JPG,PNG Images are allowed");
      this.obj.image=null;
      return;

    }
    this.obj.image=file;

    const reader = new FileReader();
    reader.onload=()=>{
      this.imagePreview=reader.result;
    };
    reader.readAsDataURL(file);

  }


  submitBook()
  {
    if(!this.obj.author||
      !this.obj.description||
      this.obj.price<=0||
      !this.obj.image
    )
    {
      this.errorMessage='Please fill all fields correctly';
      return;
    }
  }

  

}
