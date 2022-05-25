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
  loggedInPokePalCollection : any[] = [];
  pokedexWishlist! : PokedexWishlist;

  //TODO: Remove this. only for development
  dummyPokePal! : PokePal;
  //

  //for otherpokepals
  OtherPokePals = new Set<PokePal>();
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
    console.log(this.loggedInPokePal);


    this.pokePalOther = {
      user_email : "",
      user_id : 0,
      user_img_url : "",
      user_name : "",
      user_password : "",
      is_logged_in : false,
      pokedexCollection: [],
      pokedexWishlist: [],
      commentCollections : [],
      commentWishlist :  [],
    }
  }

  selectOtherPokePals() {
    this.selectedButton = this.otherPokepalMessage
    this.OtherPokePals = new Set<PokePal>();
    this.pokedexService.getAllPokePal().subscribe(val => {
      console.log(val);
      val.forEach(pokePal => {
        this.pokePalOther = {
          user_email : "",
          user_id : 0,
          user_img_url : "",
          user_name : "",
          user_password : "",
          is_logged_in : false,
          pokedexCollection: [],
          pokedexWishlist: [],
          commentCollections : [],
          commentWishlist :  [],
        }
        this.pokePalOther.user_email = pokePal.user_email;
        this.pokePalOther.user_name = pokePal.user_name;
        this.pokePalOther.user_img_url = `http://localhost:9003/api/v1/user/${pokePal.user_id}/image/download`
        this.pokePalOther.commentCollections = pokePal.commentCollections;
        this.pokePalOther.commentWishlist = pokePal.commentWishlist;
        this.pokePalOther.pokedexCollection = pokePal.pokedexCollection;
        this.pokePalOther.pokedexWishlist = pokePal.pokedexWishlist
        if (this.pokePalOther.user_email === this.loggedInPokePal.user_email) {
          // do not add
        } else {
        this.OtherPokePals.add(this.pokePalOther);
      }
        
      })
      console.log(this.OtherPokePals);
    })

    console.log(this.loggedInPokePal);
    }
  
  selectViewCollection() {
    this.selectedButton = this.viewCollectionMessage;
    console.log(this.loggedInPokePal);
    this.pokedexService.getUserPokedexCollection(this.loggedInPokePal.user_id).subscribe(val => {
      console.log(val);
      this.loggedInPokePalCollection = val;
    })
    console.log(this.loggedInPokePalCollection)
    this.sessionService.postLoggedInPokePalCollection(this.loggedInPokePalCollection)


  }
  
  selectViewWishist() {
    this.selectedButton = this.viewWishlistMessage;
    console.log(this.loggedInPokePal);
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

