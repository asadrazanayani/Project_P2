package com.revature.project_p2.comment_collection;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class CommentCollection {
    @Id
    @GeneratedValue
    private Long comment_id;
    @CreationTimestamp
    private Timestamp created_at;

    @ManyToOne()
    @JoinColumn(name = "commenter_id")
    private PokePal commenter;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private PokePal pokePal;

    @Column(columnDefinition = "TEXT")
    private String contents;


    public CommentCollection(PokePal commenter, PokePal pokePal, String content) {
        this.commenter = commenter;
        this.pokePal = pokePal;
        this.contents = content;
    }

    public CommentCollection(String contents) {
        this.contents = contents;
    }


    public CommentCollection(PokePal commenter, String contents, PokePal pokePal) {
        this.commenter = commenter;
        this.contents = contents;
        this.pokePal = pokePal;
    }

    @JsonBackReference
    public PokePal getCommenter() {
        return commenter;
    }

    @JsonBackReference
    public PokePal getPokePal() {
        return pokePal;
    }
}
