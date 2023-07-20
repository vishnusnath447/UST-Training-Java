package com.ust.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(){};

    public User(int id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
