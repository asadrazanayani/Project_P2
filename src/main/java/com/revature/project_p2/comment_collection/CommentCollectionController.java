package com.revature.project_p2.comment_collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/comments")
public class CommentCollectionController {

    @Autowired
    CommentCollectionService commentCollectionService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommentCollection add_comment(@RequestBody CommentCollection commentCollection) {

        return commentCollectionService.add_comment(commentCollection);
    }

    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public List<CommentCollection> getCommentsForCollection(@PathVariable("user_id") Long user_id) {
        return  commentCollectionService.getCommentsForCollection(user_id);
    }


}

