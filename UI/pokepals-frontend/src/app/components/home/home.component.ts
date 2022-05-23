import { Component, OnInit } from '@angular/core';
import axios from 'axios';
import { Login } from 'src/app/Entity/Login';
import { PokePal } from 'src/app/Entity/PokePal';
import { PokedexService } from 'src/app/services/pokepal/pokedex.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  pokePal! : PokePal
  loginUser! : Login;
  isCorrectInfo : boolean = false;
  hasUserID : boolean = false;
  userIDForImageUpload : number = 0;
  fileName = "";
  itemImageUrl = "";
  

  constructor(private pokedexService : PokedexService) {}

  ngOnInit(): void {
    this.pokePal = {
      user_id : 0,
      user_name : "",
      user_email : "",
      user_password : ""
    }

    this.loginUser = {
      user_email : "",
      user_password : ""
    }
  }

  addUser() {
    this.pokedexService.addPokepal(this.pokePal).subscribe(response => {
      this.userIDForImageUpload = response.user_id
      console.log(response.user_id);
      this.hasUserID = true;
    })
  }

  login() {
    console.log(this.loginUser);
    this.pokedexService.getPokePalByEmailPass(this.loginUser).subscribe(response => {
      console.log(response);
    }) 
  }

  onFileSelected(event : any) { 
    const file:File = event.target.files[0];

    if (file) {
        this.fileName = file.name;
        console.log(file);
        const formData = new FormData();
        formData.append("file", file);
        axios.post(`http://localhost:9003/api/v1/user/${this.userIDForImageUpload}/image/upload`, formData, {
          headers : {
            "Content-Types" : "multipart/form-data"
          }
        }).then(() => {
          console.log("file uploaded")
          this.itemImageUrl = `http://localhost:9003/api/v1/user/${this.userIDForImageUpload}/image/download`
        }).catch(err => {
          console.log("Error");
        })
        };
        //https://blog.angular-university.io/angular-file-upload/
  }

  }


