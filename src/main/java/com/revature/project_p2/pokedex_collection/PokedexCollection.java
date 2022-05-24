package com.revature.project_p2.pokedex_collection;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.revature.project_p2.user.PokePal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PokedexCollection {
    @Id
    @GeneratedValue
    private Long collection_id;
    @CreationTimestamp
    private Timestamp created_at;
    private String pokemon_name;
    private String pokemon_type_primary;
    private Long pokemon_base_experience;
    private String pokemon_img_url;
    private String pokemon_special_move;

//    @OneToOne(targetEntity = PokePal.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private PokePal pokePal;

    public PokedexCollection(String pokemon_name, String pokemon_type_primary, Long pokemon_base_experience, String pokemon_img_url, String pokemon_special_move, PokePal pokePal) {
        this.pokemon_name = pokemon_name;
        this.pokemon_type_primary = pokemon_type_primary;
        this.pokemon_base_experience = pokemon_base_experience;
        this.pokemon_img_url = pokemon_img_url;
        this.pokemon_special_move = pokemon_special_move;
        this.pokePal = pokePal;
    }

    public PokedexCollection(Timestamp created_at, String pokemon_name, String pokemon_type_primary, Long pokemon_base_experience, String pokemon_img_url, String pokemon_special_move) {
        this.created_at = created_at;
        this.pokemon_name = pokemon_name;
        this.pokemon_type_primary = pokemon_type_primary;
        this.pokemon_base_experience = pokemon_base_experience;
        this.pokemon_img_url = pokemon_img_url;
        this.pokemon_special_move = pokemon_special_move;
    }

    public Long getCollection_id() {
        return collection_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public String getPokemon_name() {
        return pokemon_name;
    }

    public String getPokemon_type_primary() {
        return pokemon_type_primary;
    }

    public Long getPokemon_base_experience() {
        return pokemon_base_experience;
    }

    public String getPokemon_img_url() {
        return pokemon_img_url;
    }

    public String getPokemon_special_move() {
        return pokemon_special_move;
    }
    // https://stackoverflow.com/questions/47693110/could-not-write-json-infinite-recursion-stackoverflowerror-nested-exception
    @JsonBackReference
    public PokePal getPokePal() {
        return pokePal;
    }


//    @OneToMany(targetEntity = Pokedex.class, cascade =  CascadeType.ALL)
//    @JoinColumn(name = "pokedex_collection_id", referencedColumnName = "pokedex_id")

//    @OneToMany(mappedBy="pokedexCollection")
//    private List<Pokedex> pokedex;

//    @OneToMany(mappedBy = "pokedexCollection")
//    private List<CommentCollection> commentCollections;

//    @OneToMany
//    private List<CommentCollection> commentCollections;





}
