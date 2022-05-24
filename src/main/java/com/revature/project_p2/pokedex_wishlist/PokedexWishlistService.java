package com.revature.project_p2.pokedex_wishlist;

import com.revature.project_p2.user.PokePalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokedexWishlistService {

    @Autowired
    PokedexWishlistRepository pokedexWishlistRepository;
    @Autowired
    PokePalService pokePalService;

    public PokedexWishlist addPokedexWishlist(PokedexWishlist pokedexWishlist) {
        return pokedexWishlistRepository.save(pokedexWishlist);
    }

    public List<PokedexWishlist> getpokedexWishlistByID(Long user_id) {
        return pokedexWishlistRepository.getpokedexWishlistByID(user_id);
    }
}
