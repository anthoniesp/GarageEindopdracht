package com.example.garageeindopdracht.Models;

import com.example.garageeindopdracht.Security.ApplicationUserRole;

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
    private String username;
    @Column
    private String password;
    @Column
    private ApplicationUserRole role;
    private boolean isActive;

    public User(String userName, String password, ApplicationUserRole role) {
        this.username = userName;
        this.password = password;
        this.role = role;
        this.isActive = true;
    }

    public User() {

    }

    public Long getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public ApplicationUserRole getRole() {
        return role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setID(Long id) {
        this.ID = id;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(ApplicationUserRole role) {
        this.role = role;
    }

    public int[] getRoles() {
        return null; //TODO
    }
}
