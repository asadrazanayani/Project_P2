package com.revature.project_p2.pokedex_wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokedexWishlistRepository extends JpaRepository<PokedexWishlist, Long> {
}
