//package com.revature.project_p2.comment_wishlist;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface CommentWishlistRepository extends JpaRepository<CommentWishlist, Long> {
//
//
//}

package com.revature.project_p2.comment_wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentWishlistRepository extends JpaRepository<CommentWishlist, Long> {

    @Query(value = "Select * from comment_wishlist where user_id_wishlist = ?1 ORDER BY created_at", nativeQuery = true)
    List<CommentWishlist> getCommentsForWishlist(Long user_id_wishlist);
}
