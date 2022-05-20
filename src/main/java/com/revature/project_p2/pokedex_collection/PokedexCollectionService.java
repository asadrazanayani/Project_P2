package com.revature.project_p2.pokedex_collection;

import com.revature.project_p2.user.PokePal;
import com.revature.project_p2.user.PokePalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokedexCollectionService {

    @Autowired
    PokedexCollectionRepository pokedexCollectionRepository;
    @Autowired
    PokePalService pokePalService;

    public PokedexCollection addPokedexCollection(Long user_id) {
        PokePal pal = pokePalService.getPokePalByID(user_id);
        PokedexCollection pokedexCollection = new PokedexCollection(pal);
        return pokedexCollectionRepository.save(pokedexCollection);
    }
}
