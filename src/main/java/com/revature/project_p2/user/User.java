package com.revature.project_p2.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long user_id;
    @NotBlank(message = "Username is required")
    private String user_name;
    @NotBlank(message = "Email is required")
    @Email()
    private String user_email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password is required")
    private String user_password;
    private String user_img_url;
    private Timestamp created_at;
    private Timestamp updated_al;

}
