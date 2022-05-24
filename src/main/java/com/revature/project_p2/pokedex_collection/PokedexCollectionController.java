package com.revature.project_p2.pokedex_collection;

import com.revature.project_p2.user.PokePal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/pokedex-collection")

public class PokedexCollectionController {

    @Autowired
    PokedexCollectionService pokedexCollectionService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public PokedexCollection addPokedexCollection(@RequestBody PokePal pokePal) { //https://www.baeldung.com/spring-pathvariable
        return pokedexCollectionService.addPokedexCollection(pokePal.getUser_id());
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public PokedexCollection getPokedexCollection(@RequestBody PokePal pokePal) {
        return pokedexCollectionService.getPokedexCollectionByID(pokePal.getUser_id());
    }




}
