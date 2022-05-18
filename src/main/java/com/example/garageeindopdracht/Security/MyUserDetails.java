package com.example.garageeindopdracht.Security;

import com.example.garageeindopdracht.Models.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class MyUserDetails implements UserDetails {

    private String username;
    private String password;
    private GrantedAuthority authorities;
    private boolean isActive;

//    public MyUserDetails(User user) {
//        this.username = user.getUsername();
//        this.password = user.getPassword();
//        this.isActive = user.isActive();
//        this.authorities = Arrays.stream(user.getRoles())
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection<? extends GrantedAuthority>) authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
}
