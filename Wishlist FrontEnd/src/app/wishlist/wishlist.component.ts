import { Component, OnInit } from '@angular/core';
import { Product } from '../Product';
import { WishlistService } from '../wishlist.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {

   wishlistProduct:Product[]=[];
  constructor(private wishlistservice:WishlistService) { }

   ngOnInit():void{
   
     this.wishlistservice.loadWishlistProduct().subscribe(data => {
      this.wishlistProduct = data;
    },
      error => {
        console.log("erroor occured", error);
      }
    );
  }

/**********************************
*Method:        removeFromWishlist(productId:number)
*description:   remove the product from wishlist of particular user
*paramenter :   it accept productId as a parameter
*created by:    Raman Pandey
*created date:  21-APR-2020
**********************************/
  removeFromWishlist(product:Product)
  {
      console.log(product.productId);
     this.wishlistservice.deleteWishlistProduct(product.productId).subscribe(data=>{
      alert("Record Deleted");
        this.ngOnInit();
     })
     

  }
  
 

}
