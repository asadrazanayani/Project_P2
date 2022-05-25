//package com.revature.project_p2.vote_collection;
//
//import com.revature.project_p2.common.VoteType;
//import com.revature.project_p2.pokedex_collection.PokedexCollection;
//import com.revature.project_p2.user.PokePal;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Entity
//public class VoteCollection {
//    @Id
//    @GeneratedValue
//    private Long vote_id;
//    @CreationTimestamp
//    private Timestamp created_at;
//    @OneToOne(targetEntity = PokePal.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "voter_id", referencedColumnName = "user_id")
//    private PokePal pokePal;
//    private VoteType voteType;
//    @OneToOne(targetEntity = PokedexCollection.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
//    private PokedexCollection pokedexCollection;
//}


/*
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

 */