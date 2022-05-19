package com.example.garageeindopdracht.Models;

import com.example.garageeindopdracht.Security.ApplicationUserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    @Enumerated()
    private ApplicationUserRole applicationUserRole;


    public User(String userName, String password, ApplicationUserRole applicationUserRole) {
        this.userName = userName;
        this.password = password;
        this.applicationUserRole = applicationUserRole;
    }


    public Long getUserID() {
        return userID;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.applicationUserRole.name());
        return Collections.singletonList(authority);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public ApplicationUserRole getApplicationUserRole() {
        return applicationUserRole;
    }



    public void setUserID(Long id) {
        this.userID = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setApplicationUserRole(ApplicationUserRole role) {
        this.applicationUserRole = role;
    }



    public int[] getRoles() {
        return null; //TODO
    }

}
