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

  likeProduct(productId:number, i:number){
    
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
