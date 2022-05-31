package com.revature.project_p2.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.revature.project_p2.comment_collection.CommentCollection;
import com.revature.project_p2.comment_wishlist.CommentWishlist;
import com.revature.project_p2.pokedex_collection.PokedexCollection;
import com.revature.project_p2.pokedex_wishlist.PokedexWishlist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data // getters, setters, toString, HashCode
@Entity
public class PokePal {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long user_id;
    @Column(unique = true)
    private String user_name;
    @Column(unique = true) // makes sure that the user_name is unique https://www.baeldung.com/jpa-unique-constraints
    private String user_email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String user_password;
    private String user_img_url = "";
    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;
    private Boolean is_logged_in = false;

    @JsonManagedReference
    @OneToMany(mappedBy = "pokePal", cascade = CascadeType.ALL)
    private List<PokedexCollection> pokedexCollection;

    @JsonManagedReference
    @OneToMany(mappedBy = "pokePal", cascade = CascadeType.ALL)
    private List<PokedexWishlist> pokedexWishlist;

    @JsonManagedReference(value = "commenter_collection")
    @OneToMany(mappedBy = "commenter", cascade = CascadeType.ALL)
    private List<CommentCollection> commentCollections;

    @JsonManagedReference(value = "pokePal_collection")
    @OneToMany(mappedBy = "pokePal", cascade = CascadeType.ALL)
    private List<CommentCollection> commenterCollection;

    @JsonManagedReference(value = "commenter_wishlist")
    @OneToMany(mappedBy = "commenter", cascade = CascadeType.ALL)
    private List<CommentWishlist> commentWishlist;

    @JsonManagedReference(value = "pokePal_wishlist")
    @OneToMany(mappedBy = "pokePal", cascade = CascadeType.ALL)
    private List<CommentWishlist> commenterWishlists;





//    @OneToMany(mappedBy = "user")
//    private List<CommentCollection> commentCollection;
//
//    @OneToMany(mappedBy = "user")
//    private List<CommentWishlist> commentWishlists;



    public PokePal(String user_email, String user_password) {
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public PokePal(String user_name, String user_email, String user_password, String user_img_url) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_img_url = user_img_url;
    }

    public PokePal(Long user_id, String user_email, String user_password) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_password = user_password;
    }


    public PokePal(Long user_id) {
        this.user_id = user_id;
    }
}
