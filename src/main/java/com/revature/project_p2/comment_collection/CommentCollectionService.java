package com.revature.project_p2.comment_collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentCollectionService {

    @Autowired
    CommentCollectionRepository commentCollectionRepository;

    public CommentCollection add_comment(CommentCollection commentCollection) {
        commentCollectionRepository.save(commentCollection);
        return commentCollection;
    }
}
