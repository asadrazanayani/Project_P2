import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { PokePal } from 'src/app/Entity/PokePal';
import { Login } from 'src/app/Entity/Login';

@Injectable({
  providedIn: 'root'
})
export class PokedexService {

  pokePal! : PokePal;
  loginUser! : Login;
  url : string = "http://localhost:9003/api/v1/user"
  
  constructor(private http:HttpClient) { }

  addPokepal(pokePal : PokePal)  {
    return this.http.post<PokePal>(this.url, pokePal)
  }
  
  getPokePalByEmailPass(loginPokePal : PokePal) {
    return this.http.put<PokePal>(this.url+"/login", loginPokePal);
  }

  getAllPokePal() {
    return this.http.get<PokePal[]>(this.url);
  }

  logout(loginPokePal: PokePal) {
    return this.http.put<PokePal>(this.url+"logout", loginPokePal);
  }
 

}
