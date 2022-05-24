package com.revature.project_p2.pokdex;

import com.revature.project_p2.user.PokePalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokedexService {

    @Autowired
    PokePalService pokePalService;
    @Autowired
    PokedexRepository pokedexRepository;

    public Pokedex addPokedex(Pokedex pokedex) {
        return pokedexRepository.save(pokedex);



    }
}
