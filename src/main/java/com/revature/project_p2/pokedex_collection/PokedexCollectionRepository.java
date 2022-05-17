package com.revature.project_p2.pokedex_collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokedexCollectionRepository extends JpaRepository<PokedexCollection, Long> {

}
