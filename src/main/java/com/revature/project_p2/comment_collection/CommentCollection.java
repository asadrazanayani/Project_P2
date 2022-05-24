package com.revature.project_p2.comment_collection;


import com.revature.project_p2.pokedex_collection.PokedexCollection;
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
public class CommentCollection {
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


    @Column(columnDefinition = "TEXT")
    private String contents;


    @ManyToOne(targetEntity = PokedexCollection.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private PokedexCollection pokedexCollection;

    public CommentCollection(PokePal user, PokedexCollection pokedexCollection, String content) {
        this.user = user;
        this.pokedexCollection = pokedexCollection;
        this.contents = content;
    }

    public CommentCollection(String contents) {
        this.contents = contents;
    }


}
