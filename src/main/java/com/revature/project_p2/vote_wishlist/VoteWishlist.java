package com.revature.project_p2.vote_wishlist;

import com.revature.project_p2.common.VoteType;
import com.revature.project_p2.pokedex_wishlist.PokedexWishlist;
import com.revature.project_p2.user.PokePal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data // getters, setters, toString, HashCode
@Entity
public class VoteWishlist {
    @Id
    @GeneratedValue
    private Long vote_id;
    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;
    @OneToOne(targetEntity = PokePal.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "voter_id", referencedColumnName = "user_id")
    private PokePal pokePal;
    private VoteType voteType;
    @OneToOne(targetEntity = PokedexWishlist.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "wishlist_id", referencedColumnName = "wishlist_id")
    private PokedexWishlist pokedexWishlist;

}
