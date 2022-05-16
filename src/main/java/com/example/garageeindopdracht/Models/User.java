package com.example.garageeindopdracht.Models;

import com.example.garageeindopdracht.Security.Roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
    @Id
    private long ID;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private Roles role;

    public User(String userName, String password, Roles role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    public Long getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return userName;
    }

    public Roles getRole() {
        return role;
    }


    public void setID(Long id) {
        this.ID = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
