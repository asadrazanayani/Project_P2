import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PokemonsComponent } from './components/pokemons/pokemons.component';
import { AllUsersComponent } from './components/all-users/all-users.component';
import { PostLoginHomeComponent } from './components/post-login-home/post-login-home.component';
import { OtherPokepalViewComponent } from './components/other-pokepal-view/other-pokepal-view.component';
const routes: Routes = [
  {
    path : 'pokemons', component:PokemonsComponent
  },
  {
    path : '', component : HomeComponent
  },
  {
    path : 'all-users', component : AllUsersComponent
  },
  {
    path : 'post-login', component : PostLoginHomeComponent
  },
  {
    path : 'other-view-collection', component : OtherPokepalViewComponent
  },
  {
    path : 'other-view-wishlist', component : OtherPokepalViewComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
