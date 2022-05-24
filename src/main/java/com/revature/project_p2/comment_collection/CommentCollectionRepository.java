package com.revature.project_p2.comment_collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentCollectionRepository extends JpaRepository<CommentCollection, Long> {


}
