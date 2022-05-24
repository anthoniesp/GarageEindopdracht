package com.example.garageeindopdracht.Security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

class MyUserDetailsTest {
    /**
     * Method under test: {@link MyUserDetails#getAuthorities()}
     */
    @Test
    void testGetAuthorities() {
        assertNull((new MyUserDetails("janedoe", "iloveyou", null)).getAuthorities());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link MyUserDetails#MyUserDetails(String, String, org.springframework.security.core.GrantedAuthority)}
     *   <li>{@link MyUserDetails#getPassword()}
     *   <li>{@link MyUserDetails#getUsername()}
     *   <li>{@link MyUserDetails#isAccountNonExpired()}
     *   <li>{@link MyUserDetails#isAccountNonLocked()}
     *   <li>{@link MyUserDetails#isCredentialsNonExpired()}
     *   <li>{@link MyUserDetails#isEnabled()}
     * </ul>
     */
    @Test
    void testConstructor() {
        MyUserDetails actualMyUserDetails = new MyUserDetails("janedoe", "iloveyou", new SimpleGrantedAuthority("Role"));

        assertEquals("iloveyou", actualMyUserDetails.getPassword());
        assertEquals("janedoe", actualMyUserDetails.getUsername());
        assertTrue(actualMyUserDetails.isAccountNonExpired());
        assertTrue(actualMyUserDetails.isAccountNonLocked());
        assertTrue(actualMyUserDetails.isCredentialsNonExpired());
        assertTrue(actualMyUserDetails.isEnabled());
    }
}

