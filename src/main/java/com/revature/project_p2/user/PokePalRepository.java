package com.revature.project_p2.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokePalRepository extends JpaRepository<PokePal, Long> {

    @Query(value = "SELECT * from poke_pal where user_email = ?1 and user_password = ?2", nativeQuery = true)
    List<PokePal> findUserForLogin(String user_email, String user_password);

    @Query(value = "select * from poke_pal where user_id = (select commenter_id from comment_collection where " +
            "comment_id " +
            "= ?1)", nativeQuery = true)
    PokePal getUserForCommentCollection(Long comment_id);


    @Query(value = "select * from poke_pal where user_id = (select commenter_id_wishlist from comment_wishlist where " +
            "comment_id_wishlist = ?1)", nativeQuery = true)
    PokePal getUserForCommentWishlist(Long comment_id);
}

//select * from poke_pals where user_id = (select user_id from comment_collection where comment_id = 193);

//select * from poke_pal where user_id = (select commenter_id_wishlist from comment_wishlist where comment_id_wishlist = 232)