import { Component, OnInit, Input } from '@angular/core';
// import axios from 'axios';
// import { PokedexCollection } from 'src/app/Entity/PokedexCollection';
// import { PokedexWishlist } from 'src/app/Entity/PokedexWishlist';
import { Comment } from 'src/app/Entity/Comment';
import { PokePal } from 'src/app/Entity/PokePal';
import { PokedexService } from 'src/app/services/pokepal/pokedex.service';
import { SessionServicesService } from 'src/app/services/session/session-services.service';

@Component({
  selector: 'app-post-login-home',
  templateUrl: './post-login-home.component.html',
  styleUrls: ['./post-login-home.component.css']
})
export class PostLoginHomeComponent implements OnInit {
  index! : number;
  loggedInPokePal! : PokePal;
  loggedInPokePalCollection : any[] = [];
  loggedInPokePalWishlist : any[] = [];
  comments : Comment[] = [];
  commentsName : Comment[] = []

  //TODO: Remove this. only for development
  dummyPokePal! : PokePal;
  //

  //for otherpokepals
  OtherPokePals = new Set<PokePal>();
  otherPokePal! : PokePal;
  // end of otherpokepals

  //otherPokePalView
  otherPokePalViewCollection! : PokePal;
  otherPokePalViewWishlist! : PokePal;
  //

  otherPokepalMessage = "See Other PokePals";
  viewCollectionMessage = "See your Pokedex Collection";
  viewWishlistMessage = "See your Pokedex Wishlist";
  changeProfileMessage = "Change Profile";
  logoutMessage = "Logout";
  selectedButton : string = "";

  messageText : string = '';

  constructor(private pokedexService : PokedexService, private sessionService : SessionServicesService) {
    

   }
   // get the loggedInPokePal after login/signup
  ngOnInit(): void {
    this.loggedInPokePal = this.getLoggedInPokePal();
    this.selectViewCollection();
    console.log(this.loggedInPokePal);
    this.otherPokePal = {
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
        this.otherPokePal = {
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
        this.otherPokePal.user_id = pokePal.user_id;
        this.otherPokePal.user_email = pokePal.user_email;
        this.otherPokePal.user_name = pokePal.user_name;
        this.otherPokePal.user_img_url = `http://localhost:9003/api/v1/user/${pokePal.user_id}/image/download`
        this.otherPokePal.commentCollections = pokePal.commentCollections;
        this.otherPokePal.commentWishlist = pokePal.commentWishlist;
        this.otherPokePal.pokedexCollection = pokePal.pokedexCollection;
        this.otherPokePal.pokedexWishlist = pokePal.pokedexWishlist
        if (this.otherPokePal.user_email === this.loggedInPokePal.user_email) {
          // do not add
        } else {
        this.OtherPokePals.add(this.otherPokePal);
      }
        
      })
      console.log(this.OtherPokePals);
    })

    console.log(this.loggedInPokePal);
    }
  
  selectViewCollection() {
    this.commentsName = [];
    this.comments = [];
    this.selectedButton = this.viewCollectionMessage;
    console.log(this.loggedInPokePal);
    this.pokedexService.getUserPokedexCollection(this.loggedInPokePal.user_id).subscribe(val => {
      console.log(val);
      this.loggedInPokePalCollection = val;
      // console.log(this.loggedInPokePalCollection)
    })
    this.sessionService.postLoggedInPokePalCollection(this.loggedInPokePalCollection);

    // get loggedInPokePal comments.
    this.pokedexService.getAllLoggedInPokePalCollectionComments(this.loggedInPokePal.user_id).subscribe(response => {
      this.comments = [];
      this.comments = response;
    });
    setTimeout(() => {
      this.comments.forEach(comment => {
        this.pokedexService.getPokePalForCommentCollection(comment.comment_id).subscribe(pokepal => {
          comment.commenter_name = pokepal.user_name
          this.commentsName.push(comment);
          console.log(this.commentsName);
        }) 
      });
    }, 1000);

  }
  
  selectViewWishist() {
    this.commentsName = [];
    this.comments = [];
    this.selectedButton = this.viewWishlistMessage;
    console.log(this.loggedInPokePal);
     this.pokedexService.getUserPokedexWishlist(this.loggedInPokePal.user_id).subscribe(val => {
      // console.log(val);
      this.loggedInPokePalWishlist = val;
      // console.log(this.loggedInPokePalWishlist)
    })
    this.sessionService.postLoggedInPokePalWishlist(this.loggedInPokePalWishlist);
    // get loggedIn PokePal Collection Comments
    this.pokedexService.getAllLoggedInPokePalWishlistComments(this.loggedInPokePal.user_id).subscribe(response => {
      console.log(response[0].comment_id_wishlist)
      this.comments = [];
      this.comments = response;
      console.log(this.comments[0].comment_id_wishlist);
      console.log(this.commentsName.length);

    });
    setTimeout(() => {
      this.comments.forEach(comment => {
        console.log(comment);
        this.pokedexService.getPokePalForCommentWishlist(comment.comment_id_wishlist).subscribe(pokepal => {
          console.log(pokepal)
          comment.commenter_name = pokepal.user_name
          this.commentsName.push(comment);
          console.log(this.commentsName);
        }) 
      });
    }, 1000);
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

  otherUserCollection(otherPokePal : PokePal) {
    this.otherPokePalViewCollection = otherPokePal;
    this.sessionService.postOtherPokePalViewCollection(this.otherPokePalViewCollection);
  }

  otherUserWishlist(otherPokePal : PokePal) {
    this.otherPokePalViewWishlist = otherPokePal;
    this.sessionService.postOtherPokePalViewWishlist(this.otherPokePalViewWishlist);
    
  }

  postCommentOnCollection() {
    console.log(this.messageText);
    let comment : any;
    comment = {
      commenter : 0,
      contents : "",
      pokePal : 0
    }
    comment.commenter = this.loggedInPokePal.user_id; 
    comment.contents = this.messageText;
    comment.pokePal = this.loggedInPokePal.user_id;
    console.log(comment);
    this.messageText = "";
    this.pokedexService.addCommentCollection(comment).subscribe(val => {
      console.log(val);

    });
    setTimeout(() => {
      this.selectViewCollection();
    }, 1000)
  }
  
  postCommentOnWishlist() {
    console.log(this.messageText);
    let comment : any;
    comment = {
      commenter : 0,
      contents : "",
      pokePal : 0
    }
    comment.commenter = this.loggedInPokePal.user_id; 
    comment.contents = this.messageText;
    comment.pokePal = this.loggedInPokePal.user_id;
    console.log(comment);
    this.messageText = "";
    this.pokedexService.addCommentWishlist(comment).subscribe(val => {
      console.log(val);
    });
    setTimeout(() => {
      this.selectViewWishist();
    }, 1000)
  }

}

