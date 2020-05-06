import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WishlistService {

  
  constructor(private http:HttpClient) { }
  loadWishlistProduct(): Observable<any> {
  let url = "http://localhost:1136/wishlistproduct/59";

    return this.http.get(url);
  
  }

  deleteWishlistProduct(productId:number):Observable<any>
  {
    console.log("in service pid=" + productId);
    let url = "http://localhost:1136/user/59/" + productId;
    return this.http.delete(url);
  }

  loadAllProduct():Observable<any>
  {
    console.log("inside loadAllProducts");
    let url="http://localhost:1136/allproduct/59";
    return this.http.get(url);
  }
  likeProduct(productId:number):Observable<any>{
    let url = "http://localhost:1136/user/59/" + productId;
    return this.http.get(url);
  }
  

}
