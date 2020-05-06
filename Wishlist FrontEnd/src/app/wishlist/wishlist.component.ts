import { Component, OnInit } from '@angular/core';
import { Product } from '../Product';
import { WishlistService } from '../wishlist.service';

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
  removeFromWishlist(product:Product)
  {
      console.log(product.productId);
     this.wishlistservice.deleteWishlistProduct(product.productId).subscribe(data=>{
       alert("Record Deleted");
       this.ngOnInit();
     })
  }
  
 

}
