import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PokePal } from 'src/app/Entity/PokePal';
import { PokedexService } from 'src/app/services/pokepal/pokedex.service';
import { SessionServicesService } from 'src/app/services/session/session-services.service';

@Component({
  selector: 'app-other-pokepal-view',
  templateUrl: './other-pokepal-view.component.html',
  styleUrls: ['./other-pokepal-view.component.css']
})
export class OtherPokepalViewComponent implements OnInit {

  collectionOrWishlist : string = '';
  otherPokePalViewCollection! : PokePal; 
  otherPokePalViewWishlist! : PokePal;

  otherPokePalViewCollection_Collection : any[] = [];
  otherPokePalViewWishlist_Wishlist : any[] = [];

  constructor(private router : Router, private sessionService : SessionServicesService, private pokedexService : PokedexService ) { }

  ngOnInit(): void {
    console.log(this.router.url)
    if (this.router.url.includes('collection')) {
      this.collectionOrWishlist = "Other User Collections"
      this.otherPokePalViewCollection = this.sessionService.getOtherPokePalViewCollection();
      this.pokedexService.getUserPokedexCollection(this.otherPokePalViewCollection.user_id).subscribe(val => {
        this.otherPokePalViewCollection_Collection = val;
        console.log(this.otherPokePalViewCollection_Collection);
      })
    } else {
      this.collectionOrWishlist = "Other User Wishlist"
      this.otherPokePalViewWishlist = this.sessionService.getOtherPokePalViewWishlist();
      this.pokedexService.getUserPokedexWishlist(this.otherPokePalViewWishlist.user_id).subscribe(val => {
        this.otherPokePalViewWishlist_Wishlist = val;
        console.log(this.otherPokePalViewWishlist_Wishlist);
      })
    }
  }

}
