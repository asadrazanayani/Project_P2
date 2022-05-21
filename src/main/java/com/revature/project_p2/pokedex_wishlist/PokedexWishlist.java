package com.revature.project_p2.pokedex_wishlist;


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
public class PokedexWishlist {
    @Id
    @GeneratedValue
    private Long wishlist_id;
    @CreationTimestamp
    private Timestamp created_at;
    @CreationTimestamp
    private Timestamp updated_at;
    @OneToOne(targetEntity = PokePal.class, cascade = CascadeType.ALL) //https://stackabuse.com/a-guide-to-jpa-with-hibernate-relationship-mapping/
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private PokePal pokePal;

    public PokedexWishlist(PokePal pokePal) {
        this.pokePal = pokePal;
    }

}