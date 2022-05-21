import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { PokemonService } from 'src/app/service/pokemon.service';
import { Pokeapi } from 'src/app/Entity/Pokeapi';
import { Pokedex } from 'src/app/Entity/Pokedex';
import { Result } from 'src/app/Entity/Result';
import { Pokemon } from 'src/app/Entity/Pokemon';
import { Type } from 'src/app/Entity/Type';
import { Specie } from 'src/app/Entity/Specie';
import { Move } from 'src/app/Entity/Move';
import { sprites } from 'src/app/Entity/sprites';

@Component({
  selector: 'app-pokemons',
  templateUrl: './pokemons.component.html',
  styleUrls: ['./pokemons.component.css']
})
export class PokemonsComponent implements OnInit {
  @Input() curr_page = 0;
  @Output() next_page = new EventEmitter;
  pokemons: any[] = [];
  pagination : number[] = [0, 50]; 
  increment : number = 50;
  pokeapi!: Pokeapi;
  pokedex! : Pokedex; 
  result!: Result;
  pokedexArr: Pokedex[] = [];
  count : number = 0;

 



    // id?:number;
    // pokemon_img: String;
    // pokemon_name:String;
    // pokemon_type_primary:String;
    // pokemon_type_secondary:String;
    // pokemon_special_move: String;

  constructor(private pokemonService : PokemonService) {

   }

  ngOnInit(): void {
    this.pokedex = {
      pokemon_img : "",
      pokemon_name : "",
      pokemon_type_primary : "",
      pokemon_type_secondary : "",
      pokemon_special_move : ""
    }

  
    this.getStartData();
  }

  getStartData() {
    return this.pokemonService.getPokemons(this.pagination[0], this.pagination[1]).subscribe(val => {
      this.count = val.count;
      val.results.forEach(result => {
        this.pokemonService.getPokedexData(result.name).subscribe(val => {
          let object = JSON.parse(JSON.stringify(val))
          console.log(object.types[0].type.name);
          this.pokedex = {
            pokemon_img : object.sprites.front_default,
            pokemon_name : object.species.name,
            pokemon_type_primary : object.types[0].type.name,
            pokemon_type_secondary : object.types[1].type.name,
            pokemon_special_move : object.moves[0].move.name
          }
          this.pokedexArr.push(this.pokedex)
        })
      })
    });
    
  }
  paginationMoveDown() {
    if (this.pagination[0] >= 50) this.pagination[0] = this.pagination[0] - this.increment;
    if (this.pagination[1] >= 100) this.pagination[1] = this.pagination[1] - this.increment;
    console.log(this.pagination[0])
    console.log(this.pagination[1])
  }

  paginationMoveUp() {
  if (this.pagination[1] < this.count) {
    if (this.count - this.increment >= this.pagination[1]) {
      this.pagination[0] += this.increment;
      this.pagination[1] += this.increment;
    } else if (this.count - this.increment < this.pagination[1]) {
      this.pagination[0] += this.count - this.pagination[1];
      this.pagination[1] += this.count - this.pagination[1];
    }
    this.next_page.emit();
  }

    console.log(this.pagination[0])
    console.log(this.pagination[1])
    this.ngOnInit();
  }
}
