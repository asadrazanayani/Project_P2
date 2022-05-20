package com.revature.project_p2.pokedex_collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/users/{user_id}/pokedex-collection")

public class PokedexCollectionController {

    @Autowired
    PokedexCollectionService pokedexCollectionService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public PokedexCollection addPokedexCollection(@PathVariable String user_id) { //https://www.baeldung.com/spring-pathvariable
        Long user_id_long = Long.parseLong(user_id);
        return pokedexCollectionService.addPokedexCollection(user_id_long);
    }

}
