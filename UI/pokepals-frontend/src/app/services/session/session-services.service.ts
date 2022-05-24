import { Injectable } from '@angular/core';
import { PokePal } from 'src/app/Entity/PokePal';
import { HttpClient } from '@angular/common/http';
import axios from 'axios';
import { PokedexCollection } from 'src/app/Entity/PokedexCollection';

@Injectable({
  providedIn: 'root'
})
export class SessionServicesService {
  loggedInPokePalCollection! : PokedexCollection;

  loggedInPokePal! : PokePal;
  url : string = "http://localhost:9003/api/v1"

  constructor(private httpClient : HttpClient) { }

  postLoggedInUser(loginPokePal: PokePal) {
    this.loggedInPokePal = loginPokePal;
  }

  getLoggedInUser() {
    console.log(this.loggedInPokePal);
    return this.loggedInPokePal;
  }

  getPokedexCollection() {
    return (this.httpClient.get(this.url + `/users/${this.loggedInPokePal.user_id}/pokedex-collection`));
  }

  postPokedexCollection() {
    return (this.httpClient.post(this.url + `/users/${this.loggedInPokePal.user_id}/pokedex-collection`, this.loggedInPokePal));
  }

  
}
