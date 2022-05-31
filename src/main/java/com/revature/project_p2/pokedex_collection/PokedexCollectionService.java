package com.revature.project_p2.pokedex_collection;

import com.revature.project_p2.user.PokePalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokedexCollectionService {

    @Autowired
    PokedexCollectionRepository pokedexCollectionRepository;
    @Autowired
    PokePalService pokePalService;

    public PokedexCollection addPokedexCollection(PokedexCollection pokedexCollection) {
        return pokedexCollectionRepository.save(pokedexCollection);
    }

    public List<PokedexCollection> getPokedexCollectionByID(Long user_id) {
        return pokedexCollectionRepository.findPokedexCollectionByUserID(user_id);
    }
}
