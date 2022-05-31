import { Component, OnInit } from '@angular/core';
import { PokedexService } from 'src/app/services/pokepal/pokedex.service';
import { PokePal } from 'src/app/Entity/PokePal';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.css']
})
export class AllUsersComponent implements OnInit {
  pokePals : PokePal[] = [];


  constructor(private pokedexService : PokedexService) { }

  ngOnInit(): void {
    this.getAllPokePals();
  }

  getAllPokePals() {
    this.pokedexService.getAllPokePal().subscribe(response => response.forEach(pPal => {
      this.pokePals.push(pPal);
    }))
  }
}
