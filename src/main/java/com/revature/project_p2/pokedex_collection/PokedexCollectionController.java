package com.revature.project_p2.pokedex_collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/pokedex-collection")

public class PokedexCollectionController {

    @Autowired
    PokedexCollectionService pokedexCollectionService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public PokedexCollection addPokedexCollection(@RequestBody PokedexCollection pokedexCollection) { //https://www.baeldung.com/spring-pathvariable
        return pokedexCollectionService.addPokedexCollection(pokedexCollection);
    }

    @RequestMapping(path = "/{user_id}", method = RequestMethod.GET)
    public List<PokedexCollection> getPokedexCollection(@PathVariable("user_id") Long user_id) {
        return pokedexCollectionService.getPokedexCollectionByID(user_id);
    }




}
