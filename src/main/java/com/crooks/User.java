/*
 * Copyright (c) 2016.
 */

package com.crooks;

import javax.persistence.*;

/**
 * Created by johncrooks on 6/20/16.
 */

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue      //Auto generates the id
    int id;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
