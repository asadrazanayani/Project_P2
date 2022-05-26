import { Injectable } from '@angular/core';
import { PokePal } from 'src/app/Entity/PokePal';
import { HttpClient } from '@angular/common/http';
import axios from 'axios';
import { PokedexCollection } from 'src/app/Entity/PokedexCollection';
import { PokedexWishlist } from 'src/app/Entity/PokedexWishlist';

@Injectable({
  providedIn: 'root'
})
export class SessionServicesService {


  loggedInPokePalCollection! : PokedexCollection[];
  loggedInPokePalWishlist! : PokedexWishlist[];

  otherPokePalViewWishlist! : PokePal;
  otherPokePalViewCollection! : PokePal;

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

  postLoggedInPokePalWishlist(loggedInPokePalWishlist: PokedexWishlist[]) {
    this.loggedInPokePalWishlist = loggedInPokePalWishlist
  }

  postOtherPokePalViewWishlist(otherPokePalViewWishlist: PokePal) {
    this.otherPokePalViewWishlist = otherPokePalViewWishlist;
    // console.log(this.otherPokePalViewWishlist)
  }
  postOtherPokePalViewCollection(otherPokePalViewCollection: PokePal) {
    this.otherPokePalViewCollection = otherPokePalViewCollection;
    // console.log(this.otherPokePalViewCollection)
  }

  getOtherPokePalViewWishlist() {
    return this.otherPokePalViewWishlist;
  }

  getOtherPokePalViewCollection() {
    return this.otherPokePalViewCollection;
  }


  
}
