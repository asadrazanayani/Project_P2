import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PokePal } from 'src/app/Entity/PokePal';
import { PokedexService } from 'src/app/services/pokepal/pokedex.service';
import { SessionServicesService } from 'src/app/services/session/session-services.service';
import { Comment } from 'src/app/Entity/Comment';
import { ColdObservable } from 'rxjs/internal/testing/ColdObservable';


@Component({
  selector: 'app-other-pokepal-view',
  templateUrl: './other-pokepal-view.component.html',
  styleUrls: ['./other-pokepal-view.component.css']
})
export class OtherPokepalViewComponent implements OnInit {
  index : number = 1;
  messageText : string = '';

  collectionOrWishlist : string = '';
  otherPokePalViewCollection! : PokePal; 
  otherPokePalViewWishlist! : PokePal;

  comments : Comment[] = [];
  commentsName : Comment[] = [];

  otherPokePalViewCollection_Collection : any[] = [];
  otherPokePalViewWishlist_Wishlist : any[] = [];

  constructor(private router : Router, private sessionService : SessionServicesService, private pokedexService : PokedexService ) { }

  ngOnInit(): void {
    console.log(this.router.url)
    this.comments = [];
    this.commentsName = [];
      this.viewCollection();
      this.viewWishlist();
    //   this.collectionOrWishlist = "Other User Collections"
    //   this.otherPokePalViewCollection = this.sessionService.getOtherPokePalViewCollection();
    //   console.log(this.otherPokePalViewCollection);
    //   this.pokedexService.getUserPokedexCollection(this.otherPokePalViewCollection.user_id).subscribe(val => {
    //     this.otherPokePalViewCollection_Collection = val;
    //     console.log(this.otherPokePalViewCollection_Collection);
    //     this.pokedexService.getAllLoggedInPokePalCollectionComments(this.otherPokePalViewCollection.user_id).subscribe(val => {
    //       this.comments = [];
    //       this.comments = val;
    //       this.comments.forEach(comment => {
    //         this.pokedexService.getPokePalForCommentCollection(comment.comment_id).subscribe(val => {
    //           comment.commenter_name = val.user_name;
    //           this.commentsName.push(comment);
    //           console.log(this.commentsName);
    //         });
    //       })
    //     })

    //   })
    // }
    //  if (this.router.url.includes('wishlist')) {
    //   this.collectionOrWishlist = "Other User Wishlist"
    //   this.otherPokePalViewWishlist = this.sessionService.getOtherPokePalViewWishlist();
    //   this.pokedexService.getUserPokedexWishlist(this.otherPokePalViewWishlist.user_id).subscribe(val => {
    //     this.otherPokePalViewWishlist_Wishlist = val;
    //     console.log(this.otherPokePalViewWishlist_Wishlist);
    //     this.pokedexService.getAllLoggedInPokePalWishlistComments(this.otherPokePalViewWishlist.user_id).subscribe(val => {
    //       this.comments = [];
    //       this.comments = val;
    //       this.comments.forEach(comment => {
    //         this.pokedexService.getPokePalForCommentWishlist(comment.comment_id_wishlist).subscribe(val => {
    //           comment.commenter_name = val.user_name;
    //           this.commentsName.push(comment);
    //           console.log(this.commentsName);
    //         });
    //       })
    //     })
    //   })
    // }
  }

  viewCollection() {
    if (this.router.url.includes('collection')) {
      this.index = 1;
      this.collectionOrWishlist = "Other User Collections"
      this.otherPokePalViewCollection = this.sessionService.getOtherPokePalViewCollection();
      console.log(this.otherPokePalViewCollection);
      this.pokedexService.getUserPokedexCollection(this.otherPokePalViewCollection.user_id).subscribe(val => {
        this.otherPokePalViewCollection_Collection = val;
        console.log(this.otherPokePalViewCollection_Collection);
        this.pokedexService.getAllLoggedInPokePalCollectionComments(this.otherPokePalViewCollection.user_id).subscribe(val => {
          this.comments = [];
          this.comments = val;
        })
      })
          setTimeout(() => {
            for (let i = 0; i < this.comments.length; i++) {
              this.pokedexService.getPokePalForCommentCollection(this.comments[i].comment_id).subscribe(val => {
                this.comments[i].commenter_name = val.user_name;
              })
              console.log(this.comments);
            }
          }, 1000)
    }
  }

  viewWishlist() {
    if (this.router.url.includes('wishlist')) {
      this.index = 1;
      this.collectionOrWishlist = "Other User Wishlist"
      this.otherPokePalViewWishlist = this.sessionService.getOtherPokePalViewWishlist();
      console.log(this.otherPokePalViewWishlist);
      this.pokedexService.getUserPokedexWishlist(this.otherPokePalViewWishlist.user_id).subscribe(val => {
        this.otherPokePalViewWishlist_Wishlist = val;
        console.log(this.otherPokePalViewWishlist_Wishlist);
        this.pokedexService.getAllLoggedInPokePalWishlistComments(this.otherPokePalViewWishlist.user_id).subscribe(val => {
          this.comments = [];
          this.comments = val;
        })
      })
          setTimeout(() => {
            for (let i = 0; i < this.comments.length; i++) {
              this.pokedexService.getPokePalForCommentWishlist(this.comments[i].comment_id_wishlist).subscribe(val => {
                this.comments[i].commenter_name = val.user_name;
              })
            }
            console.log(this.comments);
          }, 1000)
    }
  }

  postCommentOnCollection() {
    console.log(this.messageText);
    let comment : any;
    comment = {
      commenter : 0,
      contents : "",
      pokePal : 0
    }
    comment.commenter = this.sessionService.getLoggedInUser().user_id; 
    comment.contents = this.messageText;
    comment.pokePal = this.otherPokePalViewCollection.user_id;
    this.messageText = "";
    console.log(comment);
    this.pokedexService.addCommentCollection(comment).subscribe(val => {
      console.log(val);
    });
    setTimeout(() => {
      this.viewCollection();
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
    comment.commenter = this.sessionService.getLoggedInUser().user_id; 
    comment.contents = this.messageText;
    comment.pokePal = this.otherPokePalViewWishlist.user_id;
    this.messageText = "";
    console.log(comment);
    this.pokedexService.addCommentWishlist(comment).subscribe(val => {
      console.log(val);
    });
    setTimeout(() => {
      this.viewWishlist();
    }, 1000)
      
  }

}
