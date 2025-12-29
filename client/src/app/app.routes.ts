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
        path:'home',
        component:HomeComponent
    },
    {
        path:'login',
        component:LoginComponent
    },
    {
        path:'signup',
        component : SignupComponent
        
    },
    {
        path:'buying',
        component:BuyingComponent
    },
    {
        path:'cart',
        component : CartComponent
    },
    {
        path :'selling',
        component : SellingComponent
    }
];
