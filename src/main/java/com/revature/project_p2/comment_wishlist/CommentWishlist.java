//package com.revature.project_p2.comment_wishlist;
//
//import com.revature.project_p2.pokedex_collection.PokedexCollection;
//import com.revature.project_p2.pokedex_wishlist.PokedexWishlist;
//import com.revature.project_p2.user.PokePal;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class CommentWishlist {
//    @Id
//    @GeneratedValue
//    private Long comment_id;
//    @CreationTimestamp
//    private Timestamp created_at;
//
//    @ManyToOne(targetEntity = PokePal.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "commenter_id", referencedColumnName = "user_id")
//    private PokePal user;
//
//    @Column(columnDefinition = "TEXT")
//    private String contents;
//
//    @ManyToOne(targetEntity = PokedexCollection.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "wishlist_id", referencedColumnName = "wishlist_id")
//    private PokedexWishlist pokedexWishlist;
//
//    public CommentWishlist(PokePal user, PokedexWishlist pokedexWishlist, String content) {
//        this.user = user;
//        this.pokedexWishlist = pokedexWishlist;
//        this.contents = content;
//    }
//
//    public CommentWishlist(String contents) {
//        this.contents = contents;
//    }
//
//}

package com.revature.project_p2.comment_wishlist;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.revature.project_p2.user.PokePal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentWishlist {
    @Id
    @GeneratedValue
    private Long comment_id_wishlist;
    @CreationTimestamp
    private Timestamp created_at;

    @ManyToOne()
    @JoinColumn(name = "commenter_id_wishlist")
    private PokePal commenter;

    @ManyToOne()
    @JoinColumn(name = "user_id_wishlist")
    private PokePal pokePal;

    @Column(columnDefinition = "TEXT")
    private String contents;


    public CommentWishlist(PokePal commenter, PokePal pokePal, String content) {
        this.commenter = commenter;
        this.pokePal = pokePal;
        this.contents = content;
    }

    public CommentWishlist(String contents) {
        this.contents = contents;
    }


    public CommentWishlist(PokePal commenter, String contents, PokePal pokePal) {
        this.commenter = commenter;
        this.contents = contents;
        this.pokePal = pokePal;
    }

    @JsonBackReference(value = "commenter_wishlist")
    public PokePal getCommenter() {
        return commenter;
    }
    //https://stackoverflow.com/questions/20119142/jackson-multiple-back-reference-properties-with-name-defaultreference

    @JsonBackReference(value = "pokePal_wishlist")
    public PokePal getPokePal() {
        return pokePal;
    }
}
