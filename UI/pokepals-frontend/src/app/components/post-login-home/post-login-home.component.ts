import { Component, OnInit, Input } from '@angular/core';
import axios from 'axios';
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

  //for otherpokepals
  OtherPokePals : PokePal[] = []
  pokePalOther! : PokePal;
  // end of otherpokepals

  otherPokepalMessage = "See Other PokePals";
  viewCollectionMessage = "See your Pokedex Collection";
  viewWishlistMessage = "See your Pokedex Wishlist";
  changeProfileMessage = "Change Profile";
  logoutMessage = "Logout";
  selectedButton : string = "";

  constructor(private pokedexService : PokedexService, private sessionService : SessionServicesService) {

   }
   // get the loggedInPokePal after login/signup
  ngOnInit(): void {
    this.loggedInPokePal = this.getLoggedInPokePal();
    this.selectedButton = this.viewCollectionMessage;


    this.pokePalOther = {
      user_email : "",
      user_id : 0,
      user_img_url : "",
      user_name : "",
      user_password : "",
      is_logged_in : false,
    }
  }

  selectOtherPokePals() {
    this.selectedButton = this.otherPokepalMessage
    this.pokedexService.getAllPokePal().subscribe(val => {
      val.forEach(pokePal => {
        this.pokePalOther = {
          user_email : "",
          user_id : 0,
          user_img_url : "",
          user_name : "",
          user_password : "",
          is_logged_in : false,
        }
        this.pokePalOther.user_email = pokePal.user_email;
        this.pokePalOther.user_name = pokePal.user_name;
        this.pokePalOther.user_img_url = `http://localhost:9003/api/v1/user/${pokePal.user_id}/image/download`
        this.OtherPokePals.push(this.pokePalOther);
      })
    })

    console.log(this.loggedInPokePal);
    }
  
  selectViewCollection() {
    this.selectedButton = this.viewCollectionMessage;
  }
  
  selectViewWishist() {
    this.selectedButton = this.viewWishlistMessage;
    console.log(this.selectedButton);
  }
  
  selectChangeProfile() {
    this.selectedButton = this.changeProfileMessage;
    this.loggedInPokePal = this.sessionService.getLoggedInUser();
    console.log(this.selectedButton);
  }

  getLoggedInPokePal() : PokePal {
    return this.loggedInPokePal = this.sessionService.getLoggedInUser();
  }

  logout() {
    this.selectedButton = this.logoutMessage;
    console.log(this.selectedButton);
  }


}

