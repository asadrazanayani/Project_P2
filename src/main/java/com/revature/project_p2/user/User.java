package com.revature.project_p2.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
@Data // getters and setters
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long user_id;
    @NotBlank(message = "Username is required")
    @Column(unique = true) // makes sure that the user_name is unique https://www.baeldung.com/jpa-unique-constraints
    private String user_name;
    @NotBlank(message = "Email is required")
    @Email()
    @Column(unique = true)
    private String user_email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password is required")
    private String user_password;
    private String user_img_url;
    @CreationTimestamp //https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html#mapping-generated-CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_al;

}
