package com.example.garageeindopdracht.Models;

import com.example.garageeindopdracht.Security.ApplicationUserRole;
import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class ApplicationUser {
    @Id
    private long ID;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private ApplicationUserRole role;

    public ApplicationUser(String userName, String password, ApplicationUserRole role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public ApplicationUser() {

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

    public ApplicationUserRole getRole() {
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

    public void setRole(ApplicationUserRole role) {
        this.role = role;
    }
}
