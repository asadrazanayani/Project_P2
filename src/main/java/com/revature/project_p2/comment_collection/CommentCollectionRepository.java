package com.revature.project_p2.comment_collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentCollectionRepository extends JpaRepository<CommentCollection, Long> {

    @Query(value = "Select * from comment_collection where user_id = ?1", nativeQuery = true)
    List<CommentCollection> getCommentsForCollection(Long user_id);
}
