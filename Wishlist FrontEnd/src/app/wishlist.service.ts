import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WishlistService {

  
  constructor(private http:HttpClient) { }
/**********************************
   *Method:        loadWishlistProduct()
   *description:   load the data of wishlist of particular user
   *created by:    Raman Pandey
   *created date:  21-APR-2020
    **********************************/
  loadWishlistProduct(): Observable<any> {
  let url = "http://localhost:1136/wishlistproduct/1";

    return this.http.get(url);
  
  }

/**********************************
*Method:        deleteWishlistProduct(productId:number)
*description:   delete the product from wishlist of particular user
*paramenter :   it accept productId as a parameter
*created by:    Raman Pandey
*created date:  21-APR-2020
 **********************************/
  deleteWishlistProduct(productId:number):Observable<any>
  {
    console.log("in service pid=" + productId);
    let url = "http://localhost:1136/user/1/" + productId;
    return this.http.delete(url);
  }

/**********************************
*Method:        loadAllProduct
*description:   load all the product
*created by:    Raman Pandey
*created date:  21-APR-2020
**********************************/
  loadAllProduct():Observable<any>
  {
    console.log("inside loadAllProducts");
    let url="http://localhost:1136/product";
    return this.http.get(url);
  }
/**********************************
*Method:        likeProduct(productId:number)
*description:   like the particular product by the user
*paramenter :   it accept productId as a parameter
*created by:    Raman Pandey
*created date:  21-APR-2020
**********************************/
  likeProduct(productId:number):Observable<any>{
    let url = "http://localhost:1136/user/1/" + productId;
    return this.http.get(url);
  }
  

}
