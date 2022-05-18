package com.example.garageeindopdracht.Security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet()),
    MECHANIC(Sets.newHashSet()),
    ADMINISTRATIVE_WORKER(Sets.newHashSet());

    private final Set<UserPermissions> permissions;

    ApplicationUserRole(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermissions> getPermissions(){
        return this.permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }



}
