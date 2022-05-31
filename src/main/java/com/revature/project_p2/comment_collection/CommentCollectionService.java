package com.revature.project_p2.comment_collection;

import com.revature.project_p2.pokedex_collection.PokedexCollectionService;
import com.revature.project_p2.user.PokePalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentCollectionService {

    @Autowired
    CommentCollectionRepository commentCollectionRepository;
    @Autowired
    PokedexCollectionService pokedexCollectionService;
    @Autowired
    PokePalService pokePalService;

    public CommentCollection add_comment(CommentCollection commentCollection) {
        return commentCollectionRepository.save(commentCollection);
    }

    public List<CommentCollection> getCommentsForCollection(Long user_id) {
        return commentCollectionRepository.getCommentsForCollection(user_id);
    }
}

