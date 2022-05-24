package com.revature.project_p2.pokedex_collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokedexCollectionRepository extends JpaRepository<PokedexCollection, Long> {

    @Query(value = "SELECT * from pokedex_collection where user_id = ?1", nativeQuery = true)
    public List<PokedexCollection> findPokedexCollectionByUserID(Long user_id);

}
