package com.revature.project_p2.comment_wishlist;

import com.revature.project_p2.pokedex_wishlist.PokedexWishlist;
import com.revature.project_p2.user.PokePal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentWishlist {
    @Id
    @GeneratedValue
    private Long comment_id;
    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;
    @ManyToOne(targetEntity = PokePal.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "commenter_id", referencedColumnName = "user_id")
    private PokePal user;
    @Lob
    private String contents;
    @ManyToOne(targetEntity = PokedexWishlist.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "wishlist_id", referencedColumnName = "wishlist_id")
    private PokedexWishlist pokedexWishlist;

    public CommentWishlist(PokePal user, PokedexWishlist pokedexWishlist, String content) {
        this.user = user;
        this.pokedexWishlist = pokedexWishlist;
        this.contents = content;
    }

    public CommentWishlist(String contents) {
        this.contents = contents;
    }

}
