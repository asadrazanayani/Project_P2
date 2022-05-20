package com.revature.project_p2.pokedex_wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/users/{user_id}/pokedex-wishlist")
public class PokedexWishlistController {

    @Autowired
    PokedexWishlistService pokedexWishlistService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public PokedexWishlist addPokedexWishlist(@PathVariable ("user_id") String user_id) {
        Long user_id_long = Long.parseLong(user_id);
        return pokedexWishlistService.addPokedexWishlist(user_id_long);
    }


}
