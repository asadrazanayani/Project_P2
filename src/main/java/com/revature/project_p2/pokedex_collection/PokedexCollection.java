package com.revature.project_p2.pokedex_collection;


import com.revature.project_p2.comment_collection.CommentCollection;
import com.revature.project_p2.pokdex.Pokedex;
import com.revature.project_p2.user.PokePal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PokedexCollection {
    @Id
    @Column(name = "user_id")
    private Long collection_id;
    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;

//    @OneToOne(targetEntity = PokePal.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")

    @OneToOne()
    @MapsId
    @JoinColumn(name = "user_id")
    private PokePal pokePal;

//    @OneToMany(targetEntity = Pokedex.class, cascade =  CascadeType.ALL)
//    @JoinColumn(name = "pokedex_collection_id", referencedColumnName = "pokedex_id")

    @OneToMany(mappedBy="pokedexCollection")
    private List<Pokedex> pokedex;

    @OneToMany(mappedBy = "pokedexCollection")
    private List<CommentCollection> commentCollections;

//    @OneToMany
//    private List<CommentCollection> commentCollections;

    public PokedexCollection(PokePal pokePal) {
        this.pokePal = pokePal;
    }

}
