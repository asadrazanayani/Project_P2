import { Component, OnInit, NgModule  } from '@angular/core';
import axios from 'axios';
import { PokePal } from 'src/app/Entity/PokePal';
import { PokedexService } from 'src/app/services/pokepal/pokedex.service';
import { SessionServicesService } from 'src/app/services/session/session-services.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  displayNone = "display : ";
  signuppokePal! : PokePal
  loginPokePal! : PokePal;
  hasUserID : boolean = false;
  fileName : string = ""; // to upload img
  fileUploadMessage : string = "";

  test : string = "";

  constructor(private pokedexService : PokedexService, private sessionServices : SessionServicesService) {}

  ngOnInit(): void {
    this.test = "this is a test component";
    this.signuppokePal = {
      user_id : 0,
      user_name : "",
      user_email : "",
      user_password : "",
      user_img_url : "",
      is_logged_in : false,
      pokedexCollection: [],
      pokedexWishlist: [],
      commentCollections : [],
      commentWishlist :  [],

    }

    this.loginPokePal = {
      user_id : 0,
      user_name : "",
      user_email : "",
      user_password : "",
      user_img_url : "",
      is_logged_in : false,
      pokedexCollection: [],
      pokedexWishlist: [],
      commentCollections : [],
      commentWishlist :  [],
    }
  }

  addUser() {
    console.log(this.signuppokePal);
    this.pokedexService.addPokepal(this.signuppokePal).subscribe(response => {
      this.signuppokePal.user_id  = response.user_id;
      console.log(this.signuppokePal = response);
      this.displayNone += "none";
      this.hasUserID = true;
    })
  }

  login() {
    this.pokedexService.getPokePalByEmailPass(this.loginPokePal).subscribe(pokePal => {
      this.loginPokePal = pokePal;
      console.log(this.loginPokePal);
      this.sessionServices.postLoggedInUser(this.loginPokePal);
    })
  }

  onFileSelected(event : any) {
    const file:File = event.target.files[0];

    if (file) {
        this.fileName = file.name;
        const formData = new FormData();
        formData.append("file", file);
        // posting via axios
        axios.post(`http://192.168.4.168:9003/api/v1/user/${this.signuppokePal.user_id}/image/upload`, formData, {
          headers : {
            "Content-Types" : "multipart/form-data"
            // for images, content-type will be multipart
          }
        }).then(() => {
          this.fileUploadMessage = "Uploaded Successfully"
          setTimeout(() => {
            this.hasUserID = !this.hasUserID;
            this.fileUploadMessage = "";
          }, 2000)


        }).catch(err => {
          console.log("Error");
        })
        };
        //https://blog.angular-university.io/angular-file-upload/
  }

  sendLoggedInUser() {
    this.sessionServices.postLoggedInUser(this.loginPokePal);
  }



  }


