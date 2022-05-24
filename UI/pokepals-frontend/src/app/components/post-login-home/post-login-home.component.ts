import { Component, OnInit, Input } from '@angular/core';
import { PokedexCollection } from 'src/app/Entity/PokedexCollection';
import { PokedexWishlist } from 'src/app/Entity/PokedexWishlist';
import { PokePal } from 'src/app/Entity/PokePal';
import { PokedexService } from 'src/app/services/pokepal/pokedex.service';
import { SessionServicesService } from 'src/app/services/session/session-services.service';

@Component({
  selector: 'app-post-login-home',
  templateUrl: './post-login-home.component.html',
  styleUrls: ['./post-login-home.component.css']
})
export class PostLoginHomeComponent implements OnInit {
  loggedInPokePal! : PokePal;
  pokedexCollection! : PokedexCollection;
  pokedexWishlist! : PokedexWishlist;
  
  otherPokepalMessage = "See Other PokePals";
  viewCollectionMessage = "See your Pokedex Collection";
  viewWishlistMessage = "See your Pokedex Wishlist";
  changeProfileMessage = "Change Profile";
  logoutMessage = "Logout";
  selectedButton : string = "";

  constructor(private pokedexService : PokedexService, private sessionService : SessionServicesService) {

   }

  ngOnInit(): void {
    this.selectedButton = this.viewCollectionMessage;
  }

  selectOtherPokePals() {
    this.selectedButton = this.otherPokepalMessage
    this.loggedInPokePal = this.sessionService.getLoggedInUser();
    console.log(this.loggedInPokePal);
    }
  
  selectViewCollection() {
    this.selectedButton = this.viewCollectionMessage;
    this.loggedInPokePal = this.sessionService.getLoggedInUser();
    this.sessionService.getPokedexCollection();


    console.log(this.loggedInPokePal);
  }
  
  selectViewWishist() {
    this.selectedButton = this.viewWishlistMessage;
    this.loggedInPokePal = this.sessionService.getLoggedInUser();
    console.log(this.selectedButton);
  }
  
  selectChangeProfile() {
    this.selectedButton = this.changeProfileMessage;
    this.loggedInPokePal = this.sessionService.getLoggedInUser();
    console.log(this.selectedButton);
  }

  logout() {
    this.selectedButton = this.logoutMessage;
    console.log(this.selectedButton);
  }


}

