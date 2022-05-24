package com.revature.project_p2.comment_collection;


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
public class CommentCollection {
    @Id
    @GeneratedValue
    private Long comment_id;
    @CreationTimestamp
    private Timestamp created_at;

    @ManyToOne()
    @JoinColumn(name = "commenter_id")
    @JsonBackReference(value = "commenter_collection")
    private PokePal commenter;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "pokePal_collection")
    private PokePal pokePal;

    @Column(columnDefinition = "TEXT")
    private String contents;


//    public CommentCollection(PokePal commenter, PokePal pokePal, String content) {
//        this.commenter = commenter;
//        this.pokePal = pokePal;
//        this.contents = content;
//    }
//
//    public CommentCollection(String contents) {
//        this.contents = contents;
//    }

//
//    public CommentCollection(PokePal commenter, String contents, PokePal pokePal) {
//        this.commenter = commenter;
//        this.contents = contents;
//        this.pokePal = pokePal;
//    }
//
//    public CommentCollection(Long comment_id, PokePal commenter, PokePal pokePal, String contents) {
//        this.comment_id = comment_id;
//        this.commenter = commenter;
//        this.pokePal = pokePal;
//        this.contents = contents;
//    }

//    @JsonBackReference(value = "commenter_collection")
//    public PokePal getCommenter() {
//        return commenter;
//    }
//
//    @JsonBackReference(value = "pokePal_collection")
//    public PokePal getPokePal() {
//        return pokePal;
//    }

    public Long getComment_id() {
        return comment_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public String getContents() {
        return contents;
    }
}
