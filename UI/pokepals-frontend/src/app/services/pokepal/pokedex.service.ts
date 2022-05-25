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
    return this.http.post<PokePal>(this.url, pokePal)
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
 

}
