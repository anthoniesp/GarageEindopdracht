package com.example.garageeindopdracht.Models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.garageeindopdracht.Security.ApplicationUserRole;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User(String, String, ApplicationUserRole)}
     *   <li>{@link User#setApplicationUserRole(ApplicationUserRole)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setUserName(String)}
     *   <li>{@link User#getApplicationUserRole()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getUserName()}
     *   <li>{@link User#getUsername()}
     *   <li>{@link User#isAccountNonExpired()}
     *   <li>{@link User#isAccountNonLocked()}
     *   <li>{@link User#isCredentialsNonExpired()}
     *   <li>{@link User#isEnabled()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User("janedoe", "iloveyou", ApplicationUserRole.ADMIN);
        actualUser.setApplicationUserRole(ApplicationUserRole.ADMIN);
        actualUser.setPassword("iloveyou");
        actualUser.setUserName("janedoe");
        assertEquals(ApplicationUserRole.ADMIN, actualUser.getApplicationUserRole());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("janedoe", actualUser.getUserName());
        assertEquals("janedoe", actualUser.getUsername());
        assertTrue(actualUser.isAccountNonExpired());
        assertTrue(actualUser.isAccountNonLocked());
        assertTrue(actualUser.isCredentialsNonExpired());
        assertTrue(actualUser.isEnabled());
    }

    /**
     * Method under test: {@link User#getUserID()}
     */
    @Test
    void testGetUserID() {
        assertEquals(0L, (new User()).getUserID().longValue());
    }

    /**
     * Method under test: {@link User#getAuthorities()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuthorities() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.garageeindopdracht.Security.ApplicationUserRole.name()" because "this.applicationUserRole" is null
        //       at com.example.garageeindopdracht.Models.User.getAuthorities(User.java:46)
        //   In order to prevent getAuthorities()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAuthorities().
        //   See https://diff.blue/R013 to resolve this issue.

        (new User()).getAuthorities();
    }

    /**
     * Method under test: {@link User#getAuthorities()}
     */
    @Test
    void testGetAuthorities2() {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        Collection<? extends GrantedAuthority> actualAuthorities = user.getAuthorities();
        assertEquals(1, actualAuthorities.size());
        assertEquals("ADMIN", ((List<? extends GrantedAuthority>) actualAuthorities).get(0).getAuthority());
    }

    /**
     * Method under test: {@link User#setUserID(Long)}
     */
    @Test
    void testSetUserID() {
        User user = new User();
        user.setUserID(123L);
        assertEquals(123L, user.getUserID().longValue());
    }
}

