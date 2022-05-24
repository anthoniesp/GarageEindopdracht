package com.example.garageeindopdracht.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.garageeindopdracht.Models.User;
import com.example.garageeindopdracht.Repositories.UserRepository;
import com.example.garageeindopdracht.Security.ApplicationUserRole;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class, BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    void testGetAllUsers() {
        ArrayList<User> userList = new ArrayList<>();
        when(this.userRepository.findAll()).thenReturn(userList);
        List<User> actualAllUsers = this.userService.getAllUsers();
        assertSame(userList, actualAllUsers);
        assertTrue(actualAllUsers.isEmpty());
        verify(this.userRepository).findAll();
    }

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    void testGetAllUsers2() {
        when(this.userRepository.findAll()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.userService.getAllUsers());
        verify(this.userRepository).findAll();
    }

    /**
     * Method under test: {@link UserService#getUser(long)}
     */
    @Test
    void testGetUser() {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(user, this.userService.getUser(1L));
        verify(this.userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#getUser(long)}
     */
    @Test
    void testGetUser2() {
        when(this.userRepository.findById((Long) any())).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.userService.getUser(1L));
        verify(this.userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#newUser(User)}
     */
    @Test
    void testNewUser() {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");

        User user1 = new User();
        user1.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user1.setPassword("iloveyou");
        user1.setUserID(123L);
        user1.setUserName("janedoe");
        Optional<User> ofResult = Optional.of(user1);
        when(this.userRepository.save((User) any())).thenReturn(user);
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);

        User user2 = new User();
        user2.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user2.setPassword("iloveyou");
        user2.setUserID(123L);
        user2.setUserName("janedoe");
        assertThrows(RuntimeException.class, () -> this.userService.newUser(user2));
        verify(this.userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#newUser(User)}
     */
    @Test
    void testNewUser2() {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user);
        when(this.userRepository.findById((Long) any())).thenReturn(Optional.empty());

        User user1 = new User();
        user1.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user1.setPassword("iloveyou");
        user1.setUserID(123L);
        user1.setUserName("janedoe");
        this.userService.newUser(user1);
        verify(this.userRepository).save((User) any());
        verify(this.userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#newUser(User)}
     */
    @Test
    void testNewUser3() {
        when(this.userRepository.save((User) any())).thenThrow(new RuntimeException("An error occurred"));
        when(this.userRepository.findById((Long) any())).thenThrow(new RuntimeException("An error occurred"));

        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        assertThrows(RuntimeException.class, () -> this.userService.newUser(user));
        verify(this.userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#editUser(User)}
     */
    @Test
    void testEditUser() {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user1.setPassword("iloveyou");
        user1.setUserID(123L);
        user1.setUserName("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);

        User user2 = new User();
        user2.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user2.setPassword("iloveyou");
        user2.setUserID(123L);
        user2.setUserName("janedoe");
        this.userService.editUser(user2);
        verify(this.userRepository).save((User) any());
        verify(this.userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#editUser(User)}
     */
    @Test
    void testEditUser2() {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.save((User) any())).thenThrow(new RuntimeException("An error occurred"));
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);

        User user1 = new User();
        user1.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user1.setPassword("iloveyou");
        user1.setUserID(123L);
        user1.setUserName("janedoe");
        assertThrows(RuntimeException.class, () -> this.userService.editUser(user1));
        verify(this.userRepository).save((User) any());
        verify(this.userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#editUser(User)}
     */
    @Test
    void testEditUser3() {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user);
        when(this.userRepository.findById((Long) any())).thenReturn(Optional.empty());

        User user1 = new User();
        user1.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user1.setPassword("iloveyou");
        user1.setUserID(123L);
        user1.setUserName("janedoe");
        this.userService.editUser(user1);
        verify(this.userRepository).findById((Long) any());
        assertEquals(ApplicationUserRole.ADMIN, user1.getApplicationUserRole());
        assertEquals("janedoe", user1.getUsername());
        assertEquals(123L, user1.getUserID().longValue());
        assertEquals("iloveyou", user1.getPassword());
        assertTrue(this.userService.getAllUsers().isEmpty());
    }

    /**
     * Method under test: {@link UserService#deleteUser(long)}
     */
    @Test
    void testDeleteUser() {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        Optional<User> ofResult = Optional.of(user);
        doNothing().when(this.userRepository).delete((User) any());
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        this.userService.deleteUser(1L);
        verify(this.userRepository).findById((Long) any());
        verify(this.userRepository).delete((User) any());
        assertTrue(this.userService.getAllUsers().isEmpty());
    }

    /**
     * Method under test: {@link UserService#deleteUser(long)}
     */
    @Test
    void testDeleteUser2() {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        Optional<User> ofResult = Optional.of(user);
        doThrow(new RuntimeException("An error occurred")).when(this.userRepository).delete((User) any());
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(RuntimeException.class, () -> this.userService.deleteUser(1L));
        verify(this.userRepository).findById((Long) any());
        verify(this.userRepository).delete((User) any());
    }

    /**
     * Method under test: {@link UserService#deleteUser(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteUser3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.orElse(Object)" because the return value of "com.example.garageeindopdracht.Repositories.UserRepository.findById(Object)" is null
        //       at com.example.garageeindopdracht.Services.UserService.deleteUser(UserService.java:66)
        //   In order to prevent deleteUser(long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deleteUser(long).
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(this.userRepository).delete((User) any());
        when(this.userRepository.findById((Long) any())).thenReturn(null);
        this.userService.deleteUser(1L);
    }

    /**
     * Method under test: {@link UserService#deleteUser(long)}
     */
    @Test
    void testDeleteUser4() {
        doNothing().when(this.userRepository).delete((User) any());
        when(this.userRepository.findById((Long) any())).thenReturn(Optional.empty());
        this.userService.deleteUser(1L);
        verify(this.userRepository).findById((Long) any());
        assertTrue(this.userService.getAllUsers().isEmpty());
    }
}

