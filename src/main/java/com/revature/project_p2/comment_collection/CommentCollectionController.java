package com.revature.project_p2.comment_collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentCollectionController {
    @Autowired
    CommentCollectionService commentCollectionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommentCollection add_comment(@RequestBody CommentCollection commentCollection) {
        return commentCollectionService.add_comment(commentCollection);
    }
}
