package com.revature.project_p2.pokedex_wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pokedex-wishlist")
public class PokedexWishlistController {

    @Autowired
    PokedexWishlistService pokedexWishlistService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public PokedexWishlist addPokedexWishlist(@RequestBody PokedexWishlist pokedexWishlist) {
        return pokedexWishlistService.addPokedexWishlist(pokedexWishlist);
    }

    @RequestMapping(path = "/{user_id}", method = RequestMethod.GET)
    public List<PokedexWishlist> getPokedexWishlist(@PathVariable("user_id") Long user_id) {
        return pokedexWishlistService.getpokedexWishlistByID(user_id);
    }


}
