import { Component, OnInit } from '@angular/core';
import { Login } from 'src/app/Entity/Login';
import { PokePal } from 'src/app/Entity/PokePal';
import { PokedexService } from 'src/app/services/pokepal/pokedex.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  pokePal! : PokePal
  loginUser! : Login;
  isCorrectInfo : boolean = false;
  

  constructor(private pokedexService : PokedexService) {}

  ngOnInit(): void {
    this.pokePal = {
      user_name : "",
      user_email : "",
      user_password : ""
    }

    this.loginUser = {
      user_email : "",
      user_password : ""
    }
  }

  addUser() {
    this.pokedexService.addPokepal(this.pokePal).subscribe(response => {
      console.log(response);
    })
  }

  login() {
    console.log(this.loginUser);
    this.pokedexService.getPokePalByEmailPass(this.loginUser).subscribe(response => {
      console.log(response);
    }) 
  }



}
