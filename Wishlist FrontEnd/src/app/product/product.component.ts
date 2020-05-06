import { Component, OnInit } from '@angular/core';
import { WishlistService } from '../wishlist.service';
import { Product } from '../Product';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  allProducts:Product[]=[];
  

  constructor(private wishlist:WishlistService) { }

  ngOnInit(): void {

    console.log("INSIDE ngOnInit of product component");
   this.wishlist.loadAllProduct().subscribe(data=>{
     this.allProducts=data;
   },
   error=>{
     console.log("Not able to fetch Product from DB",error);
   }
   )
  }

/**********************************
*Method:        likeProduct(productId:number)
*description:   like the particular product by the user
*paramenter :   it accept productId as a parameter
*created by:    Raman Pandey
*created date:  21-APR-2020
**********************************/
  likeProduct(productId:number){
    
    console.log(productId);
    this.wishlist.likeProduct(productId).subscribe(data=>{
      alert("you have liked Product with ID " + productId);
    },
    (error:HttpErrorResponse)=>{
      alert(`${error.error}`);
    }
    );
    

  }
  
  
}
