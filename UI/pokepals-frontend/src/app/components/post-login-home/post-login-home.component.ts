import { Component, OnInit, Input } from '@angular/core';
import { Comment } from 'src/app/Entity/Comment';
import { PokePal } from 'src/app/Entity/PokePal';
import { PokedexService } from 'src/app/services/pokepal/pokedex.service';
import { SessionServicesService } from 'src/app/services/session/session-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-login-home',
  templateUrl: './post-login-home.component.html',
  styleUrls: ['./post-login-home.component.css']
})
export class PostLoginHomeComponent implements OnInit {
  index : number = 1;
  loggedInPokePal! : PokePal;
  loggedInPokePalCollection : any[] = [];
  loggedInPokePalWishlist : any[] = [];
  comments : Comment[] = [];
  commentsName : Comment[] = []


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

  constructor(private pokedexService : PokedexService, private sessionService : SessionServicesService, private route : Router) {
    

   }
   // get the loggedInPokePal after login/signup
  ngOnInit(): void {
    this.loggedInPokePal = this.getLoggedInPokePal();
    this.loggedInPokePal.user_img_url = `http://localhost:9003/api/v1/user/${this.loggedInPokePal.user_id}/image/download`;
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
    this.index = 1;
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
    this.index = 1;
    this.commentsName = [];
    this.comments = [];
    this.selectedButton = this.viewCollectionMessage;
    console.log(this.loggedInPokePal);
    this.pokedexService.getUserPokedexCollection(this.loggedInPokePal.user_id).subscribe(val => {
      // console.log(val);
      this.loggedInPokePalCollection = val;
      // console.log(this.loggedInPokePalCollection)
    })
    this.sessionService.postLoggedInPokePalCollection(this.loggedInPokePalCollection);
    // get loggedInPokePal comments.
    this.pokedexService.getAllLoggedInPokePalCollectionComments(this.loggedInPokePal.user_id).subscribe(response => {
      this.comments = [];
      this.comments = response;
      console.log(this.comments);
    });
    setTimeout(() => {
     for (let i = 0; i < this.comments.length; i++) {
       this.pokedexService.getPokePalForCommentCollection(this.comments[i].comment_id).subscribe(val => {
        this.comments[i].commenter_name = val.user_name;
       });
     }
    }, 1000)

  }
  
  selectViewWishist() {
    this.index = 1;
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
      this.comments = [];
      this.comments = response;
      console.log(this.comments);
    });
    setTimeout(() => {
      for (let i = 0; i < this.comments.length; i++) {
        this.pokedexService.getPokePalForCommentWishlist(this.comments[i].comment_id_wishlist).subscribe(val => {
         this.comments[i].commenter_name = val.user_name;
        });
      }
     }, 1000)
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
    this.pokedexService.logout(this.loggedInPokePal).subscribe(val => {
      console.log(val); 
    })
    console.log(this.selectedButton);
    this.route.navigate([''])
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

  onUpdateUserInfo() {
    console.log(this.loggedInPokePal);
    this.pokedexService.updateLoggedInUserInfo(this.loggedInPokePal).subscribe(val => {
      console.log(val);
    });
    this.route.navigate([''])
  }

}

