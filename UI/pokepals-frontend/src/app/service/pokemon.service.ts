import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Pokeapi } from '../Entity/Pokeapi';


@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  constructor(private http:HttpClient) { }

  getPokemons(offset : number, limit : number) {
    return this.http.get<Pokeapi>(`https://pokeapi.co/api/v2/pokemon?offset=${offset}&limit=${limit}`);
  }
  getPokedexData(name : string) {
    return this.http.get<any>("https://pokeapi.co/api/v2/pokemon/"+name);
    
  }
}
