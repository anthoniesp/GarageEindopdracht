package com.example.garageeindopdracht.Services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.garageeindopdracht.Models.User;
import com.example.garageeindopdracht.Repositories.UserRepository;
import com.example.garageeindopdracht.Security.ApplicationUserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MyUserDetailsService.class})
@ExtendWith(SpringExtension.class)
class MyUserDetailsServiceTest {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link MyUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        when(this.userRepository.findByUserName((String) any())).thenReturn(user);
        assertSame(user, this.myUserDetailsService.loadUserByUsername("janedoe"));
        verify(this.userRepository).findByUserName((String) any());
    }

    /**
     * Method under test: {@link MyUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        when(this.userRepository.findByUserName((String) any())).thenThrow(new UsernameNotFoundException("Msg"));
        assertThrows(UsernameNotFoundException.class, () -> this.myUserDetailsService.loadUserByUsername("janedoe"));
        verify(this.userRepository).findByUserName((String) any());
    }
}

