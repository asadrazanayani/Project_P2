package com.revature.project_p2.pokdex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokedexRepository extends JpaRepository<Pokedex, Long> {
}
