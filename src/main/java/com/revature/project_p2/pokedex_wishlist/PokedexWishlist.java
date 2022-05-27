package com.revature.project_p2.pokedex_wishlist;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.revature.project_p2.user.PokePal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "pokedex_wishlist",
        uniqueConstraints={@UniqueConstraint(columnNames ={"pokemon_name","user_id"})})
// https://stackoverflow.com/questions/3126769/uniqueconstraint-annotation-in-java/50227050#50227050
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"pokemon_name", "user_id"})})

public class PokedexWishlist {
    @Id
    @GeneratedValue
    private Long wishlist_id;
    @CreationTimestamp
    private Timestamp created_at;
//    @Column(unique = true)
    private String pokemon_name;
    private String pokemon_type_primary;
    private Long pokemon_base_experience;
    private String pokemon_img_url;
    private String pokemon_special_move;


//    @OneToOne(targetEntity = PokePal.class, cascade = CascadeType.ALL) //https://stackabuse.com/a-guide-to-jpa-with-hibernate-relationship-mapping/
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private PokePal pokePal;

    public PokedexWishlist(String pokemon_name, String pokemon_type_primary, Long pokemon_base_experience, String pokemon_img_url, String pokemon_special_move, PokePal pokePal) {
        this.pokemon_name = pokemon_name;
        this.pokemon_type_primary = pokemon_type_primary;
        this.pokemon_base_experience = pokemon_base_experience;
        this.pokemon_img_url = pokemon_img_url;
        this.pokemon_special_move = pokemon_special_move;
        this.pokePal = pokePal;
    }

    public Long getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(Long wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public String getPokemon_name() {
        return pokemon_name;
    }

    public void setPokemon_name(String pokemon_name) {
        this.pokemon_name = pokemon_name;
    }

    public String getPokemon_type_primary() {
        return pokemon_type_primary;
    }

    public void setPokemon_type_primary(String pokemon_type_primary) {
        this.pokemon_type_primary = pokemon_type_primary;
    }

    public Long getPokemon_base_experience() {
        return pokemon_base_experience;
    }

    public void setPokemon_base_experience(Long pokemon_base_experience) {
        this.pokemon_base_experience = pokemon_base_experience;
    }

    public String getPokemon_img_url() {
        return pokemon_img_url;
    }

    public void setPokemon_img_url(String pokemon_img_url) {
        this.pokemon_img_url = pokemon_img_url;
    }

    public String getPokemon_special_move() {
        return pokemon_special_move;
    }

    public void setPokemon_special_move(String pokemon_special_move) {
        this.pokemon_special_move = pokemon_special_move;
    }

    @JsonBackReference
    public PokePal getPokePal() {
        return pokePal;
    }

    public void setPokePal(PokePal pokePal) {
        this.pokePal = pokePal;
    }

//    @OneToMany(mappedBy = "pokedexWishlist")
//    private List<CommentWishlist> commentWishlist;

//    @OneToMany(mappedBy="pokedexWishlist")
//    private List<Pokedex> pokedex;


}
