import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { BuyingComponent } from './buying/buying.component';
import { CartComponent } from './cart/cart.component';
import { SellingComponent } from './selling/selling.component';

export const routes: Routes = [

    {
        path:'',
        redirectTo:'/Home',
        pathMatch:'full'
    },
    {
        path:'',
        component:HomeComponent
    },
    {
        path:'Home',
        component:HomeComponent
    },
    {
        path:'Login',
        component:LoginComponent
    },
    {
        path:'Signup',
        component : SignupComponent
        
    },
    {
        path:'Buying',
        component:BuyingComponent
    },
    {
        path:'Cart',
        component : CartComponent
    },
    {
        path :'Selling',
        component : SellingComponent
    }
];
