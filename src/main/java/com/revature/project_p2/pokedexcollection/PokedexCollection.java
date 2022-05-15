package com.revature.project_p2.pokedexcollection;


import com.revature.project_p2.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PokedexCollection {
    @Id
    @GeneratedValue
    private Long pokedexCollection_id;
    private Timestamp created_at;
    private Timestamp updated_at;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
