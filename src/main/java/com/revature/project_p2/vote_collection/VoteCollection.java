package com.revature.project_p2.vote_collection;

import com.revature.project_p2.common.VoteType;
import com.revature.project_p2.pokedex_collection.PokedexCollection;
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
@Data
@Entity
public class VoteCollection {
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
    @OneToOne(targetEntity = PokedexCollection.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private PokedexCollection pokedexCollection;
}
