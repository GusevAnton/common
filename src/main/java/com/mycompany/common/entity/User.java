package com.mycompany.common.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.mycompany.common.view.UserView;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

@Data
@Entity(name = "CLIENT")
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "username", unique = true)
    @JsonView(UserView.Register.class)
    private String username;

    @Column(name = "email", unique = true)
    @Email
    @JsonView(UserView.Register.class)
    private String email;

    @Column(name = "password")
//    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
    @JsonView(UserView.Register.class)
    private String password;

    @Column(name = "activated")
    @JsonView(UserView.Register.Ignore.class)
    private boolean activated;

    @Column(name = "activation_key")
    @JsonView(UserView.Register.Ignore.class)
    private String activationKey;

//    @JsonView(UserView.Register.Ignore.class)
//    @Column(name = "authority")
//    private List<String> authorityList;

}
