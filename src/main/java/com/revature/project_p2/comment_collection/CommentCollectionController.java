package com.revature.project_p2.comment_collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users/{user_id}/pokedex-collection/{collection_id}/comments")
public class CommentCollectionController {

    @Autowired
    CommentCollectionService commentCollectionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommentCollection add_comment(@PathVariable("user_id") String commenter_id,
                                         @PathVariable("collection_id") String collection_id,
                                         @RequestBody CommentCollection commentCollection) {
        Long commenter_id_long = Long.parseLong(commenter_id);
        Long collection_id_long = Long.parseLong(collection_id);
        return commentCollectionService.add_comment(commentCollection, commenter_id_long, collection_id_long);
    }
}
