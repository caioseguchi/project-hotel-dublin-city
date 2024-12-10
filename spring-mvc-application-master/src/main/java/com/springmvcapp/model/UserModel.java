package com.springmvcapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Username", unique = true)
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private UserRole role;;

}

/*@Data
public class UserModel {

    private String username;
    private String name;
    private String password;
    private UserRole role;
}*/
