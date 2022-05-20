package com.revature.project_p2.pokedex_wishlist;

import com.revature.project_p2.user.PokePal;
import com.revature.project_p2.user.PokePalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokedexWishlistService {

    @Autowired
    PokedexWishlistRepository pokedexWishlistRepository;
    @Autowired
    PokePalService pokePalService;

    public PokedexWishlist addPokedexWishlist(Long user_id_long) {
        PokePal pokePal = pokePalService.getPokePalByID(user_id_long);
        PokedexWishlist pokedexWishlist = new PokedexWishlist(pokePal);
        return pokedexWishlistRepository.save(pokedexWishlist);
    }
}
