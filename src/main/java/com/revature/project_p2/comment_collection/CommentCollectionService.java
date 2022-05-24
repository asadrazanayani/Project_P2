package com.revature.project_p2.comment_collection;

import com.revature.project_p2.pokedex_collection.PokedexCollection;
import com.revature.project_p2.pokedex_collection.PokedexCollectionService;
import com.revature.project_p2.user.PokePal;
import com.revature.project_p2.user.PokePalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentCollectionService {

    @Autowired
    CommentCollectionRepository commentCollectionRepository;
    @Autowired
    PokedexCollectionService pokedexCollectionService;
    @Autowired
    PokePalService pokePalService;

    public CommentCollection add_comment( CommentCollection comment,  Long collection_id_long, Long commenter_id_long) {
        PokedexCollection pokedexCollection = pokedexCollectionService.getPokedexCollectionByID(collection_id_long);
        PokePal commenter = pokePalService.getPokePalByID(commenter_id_long);
        comment.setUser(commenter);
        comment.setPokedexCollection(pokedexCollection);
        return commentCollectionRepository.save(comment);
    }
}
