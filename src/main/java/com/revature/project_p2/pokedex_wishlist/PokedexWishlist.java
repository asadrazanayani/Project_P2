package com.revature.project_p2.pokedex_wishlist;


import com.revature.project_p2.pokdex.Pokedex;
import com.revature.project_p2.user.PokePal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PokedexWishlist {
    @Id
    @Column(name = "user_id")
    private Long wishlist_id;
    @CreationTimestamp
    private Timestamp created_at;
    @CreationTimestamp
    private Timestamp updated_at;

//    @OneToOne(targetEntity = PokePal.class, cascade = CascadeType.ALL) //https://stackabuse.com/a-guide-to-jpa-with-hibernate-relationship-mapping/
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @OneToOne()
    @MapsId
    @JoinColumn(name = "user_id")
    private PokePal pokePal;

    @OneToMany(mappedBy="pokedexWishlist")
    private List<Pokedex> pokedex;

    public PokedexWishlist(PokePal pokePal) {
        this.pokePal = pokePal;
    }

}
