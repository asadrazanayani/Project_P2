package com.revature.project_p2.pokedex_collection;


import com.revature.project_p2.user.PokePal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PokedexCollection {
    @Id
    @GeneratedValue
    private Long collection_id;
    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;
    @OneToOne(targetEntity = PokePal.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private PokePal pokePal;

    public PokedexCollection(PokePal pokePal) {
        this.pokePal = pokePal;
    }
}
