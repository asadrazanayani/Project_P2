package com.revature.project_p2.pokedex_collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user/{user_id}/pokedex-collection/")
public class PokedexCollectionController {

    private final PokedexCollectionService pokedexCollectionService;

    @Autowired
    public PokedexCollectionController(PokedexCollectionService pokedexCollectionService) {
        this.pokedexCollectionService = pokedexCollectionService;
    }


}
