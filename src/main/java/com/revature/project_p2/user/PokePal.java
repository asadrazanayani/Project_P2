package com.revature.project_p2.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
@Data // getters, setters, toString, HashCode
@Entity
public class PokePal {
    @Id
    @GeneratedValue
    private Long user_id;
    @Column(unique = true) // makes sure that the user_name is unique https://www.baeldung.com/jpa-unique-constraints
    private String user_name;
    @Column(unique = true)
    private String user_email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String user_password;
    private String user_img_url;
    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") //https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html#mapping-generated-CreationTimestamp
    private Timestamp created_at;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private Timestamp updated_al;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE") // https://www.baeldung.com/jpa-default-column-values
    private Boolean is_logged_in;

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


}
