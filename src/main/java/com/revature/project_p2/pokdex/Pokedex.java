//package com.revature.project_p2.pokdex;
//
//
//import com.revature.project_p2.comment_collection.CommentCollection;
//import com.revature.project_p2.pokedex_collection.PokedexCollection;
//import com.revature.project_p2.pokedex_wishlist.PokedexWishlist;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Pokedex {
//    @Id
//    @GeneratedValue
//    private Long pokedex_id;
//    private String pokemon_name;
//    private String pokemon_type_primary;
//    private Long pokemon_base_experience;
//    private String pokemon_img_url;
//    private String pokemon_special_move;
//
//    @ManyToOne
//    @JoinColumn(name = "pokedex_collection")
//    private PokedexCollection pokedexCollection;
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "pokedex_wishlist")
//    private PokedexWishlist pokedexWishlist;
//
////    @ManyToOne
////    @JoinColumn(name="collection_id")
////    private PokedexCollection pokedexCollection;
//
//    public Pokedex(String pokemon_name, String pokemon_type_primary, Long pokemon_base_experience, String pokemon_img_url, String pokemon_special_move) {
//        this.pokemon_name = pokemon_name;
//        this.pokemon_type_primary = pokemon_type_primary;
//        this.pokemon_base_experience = pokemon_base_experience;
//        this.pokemon_img_url = pokemon_img_url;
//        this.pokemon_special_move = pokemon_special_move;
//    }
////    @ManyToOne(targetEntity = PokedexCollection.class, cascade = CascadeType.ALL)
////    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
////    private PokedexCollection pokedexCollection;
////    @ManyToOne(targetEntity = PokedexCollection.class, cascade = CascadeType.ALL)
////    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
////    private PokedexWishlist pokedexWishlist;
//
////    public Pokedex(PokedexCollection pokedexCollection) {
////        this.pokedexCollection = pokedexCollection;
////    }
//
//    @OneToMany(mappedBy = "user")
//    private List<CommentCollection> commentCollections;
//
//}
