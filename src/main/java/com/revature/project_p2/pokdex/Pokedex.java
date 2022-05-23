package com.revature.project_p2.pokdex;


import com.revature.project_p2.pokedex_collection.PokedexCollection;
import com.revature.project_p2.pokedex_wishlist.PokedexWishlist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pokedex {
    @Id
    @GeneratedValue
    private Long pokedex_id;
    private String pokemon_name;
    private String pokemon_type_primary;
    private Long pokemon_base_experience;
    private String pokemon_img_url;
    private String pokemon_special_move;
    @ManyToOne(targetEntity = PokedexCollection.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "collection_id", referencedColumnName = "collection_id")
    private PokedexCollection pokedexCollection;
    @ManyToOne(targetEntity = PokedexWishlist.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "wishlist_id", referencedColumnName = "wishlist_id")
    private PokedexWishlist pokedexWishlist;

    public Pokedex(PokedexCollection pokedexCollection) {
        this.pokedexCollection = pokedexCollection;
    }

    public Pokedex(PokedexWishlist pokedexWishlist) {
        this.pokedexWishlist = pokedexWishlist;
    }

}
