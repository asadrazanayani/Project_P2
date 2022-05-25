import { Injectable } from '@angular/core';
import { PokePal } from 'src/app/Entity/PokePal';
import { HttpClient } from '@angular/common/http';
import axios from 'axios';
import { PokedexCollection } from 'src/app/Entity/PokedexCollection';

@Injectable({
  providedIn: 'root'
})
export class SessionServicesService {

  loggedInPokePalCollection! : PokedexCollection[];

  dummyPokePal : PokePal = {
    user_id :  207,
    user_name: "",
    user_email : "dummy1@domain.com",
    user_password : "",
    user_img_url : "",
    is_logged_in : true,
    pokedexCollection: [],
    pokedexWishlist: [],
    commentCollections : [],
    commentWishlist :  []

  }

  loggedInPokePal! : PokePal;
  url : string = "http://localhost:9003/api/v1"

  constructor(private httpClient : HttpClient) { }

  postLoggedInUser(loginPokePal: PokePal) {
    this.loggedInPokePal = loginPokePal;
  }

  getLoggedInUser() {
    console.log(this.loggedInPokePal);
    return this.dummyPokePal;
  }

  getPokedexCollection() {
    return (this.httpClient.get(this.url + `/users/${this.loggedInPokePal.user_id}/pokedex-collection`));
  }

  addPokedexIntoCollection() {
    return (this.httpClient.post(this.url + `/users/${this.loggedInPokePal.user_id}/pokedex-collection`, this.loggedInPokePal));
  }

  postLoggedInPokePalCollection(pokedexCollection: PokedexCollection[]) {
    this.loggedInPokePalCollection = pokedexCollection
  }

  
}
