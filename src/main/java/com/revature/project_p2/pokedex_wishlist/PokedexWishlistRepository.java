package com.revature.project_p2.pokedex_wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokedexWishlistRepository extends JpaRepository<PokedexWishlist, Long> {

    @Query(value = "Select * from pokedex_wishlist where user_id = ?1", nativeQuery = true)
    List<PokedexWishlist> getpokedexWishlistByID(Long user_id);
}
