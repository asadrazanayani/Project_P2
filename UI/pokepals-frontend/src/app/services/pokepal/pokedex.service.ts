import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { PokePal } from 'src/app/Entity/PokePal';
import { Login } from 'src/app/Entity/Login';
import { PokedexCollection } from 'src/app/Entity/PokedexCollection';
import { Pokedex } from 'src/app/Entity/Pokedex';

@Injectable({
  providedIn: 'root'
})
export class PokedexService {

  pokePal! : PokePal;
  loginUser! : Login;
  url : string = "http://localhost:9003/api/v1"
  
  constructor(private http:HttpClient) { }

  addPokepal(pokePal : PokePal)  {
    return this.http.post<PokePal>(this.url+"/user", pokePal)
  }
  
  getPokePalByEmailPass(loginPokePal : PokePal) {
    return this.http.put<PokePal>(this.url+"/user/login", loginPokePal);
  }

  getAllPokePal() {
    return this.http.get<PokePal[]>(this.url+"/user");
  }

  logout(loginPokePal: PokePal) {
    return this.http.put<PokePal>(this.url+"/user/logout", loginPokePal);
  }

  getUserPokedexCollection(user_id: number) {
    return this.http.get<any[]>(this.url + `/pokedex-collection/${user_id}`);
  }

  addPokedexToCollection(pokedex : Pokedex) {
    return this.http.post<Pokedex>(this.url + `/pokedex-collection`,pokedex)
  }

  getUserPokedexWishlist(user_id: number) {
    return this.http.get<any[]>(this.url + `/pokedex-wishlist/${user_id}`);
  }

  addPokedexToWishlist(pokedex : Pokedex) {
    return this.http.post<Pokedex>(this.url + `/pokedex-wishlist`,pokedex)
  }

  getAllLoggedInPokePalWishlistComments(user_id : number) {
    return this.http.get<any[]>(this.url + `/comments-wishlist/${user_id}`);
  }
  getAllLoggedInPokePalCollectionComments(user_id : number) {
    return this.http.get<any[]>(this.url + `/comments/${user_id}`);
  }

  getPokePalForCommentCollection(comment_id: number) {
    return this.http.get<PokePal>(this.url+`/user/commentInfo-collection/${comment_id}`)
  }

  getPokePalForCommentWishlist(comment_id: number) {
    return this.http.get<PokePal>(this.url+`/user/commentInfo-wishlist/${comment_id}`)
  }

  addCommentCollection(comment: any) {
    return this.http.post(this.url + `/comments`, comment);
  }

  addCommentWishlist(comment: any) {
    return this.http.post(this.url + `/comments-wishlist`, comment);
  }

 
 

}
