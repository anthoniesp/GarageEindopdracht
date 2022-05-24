package com.example.garageeindopdracht.Controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.garageeindopdracht.Models.User;
import com.example.garageeindopdracht.Security.ApplicationUserRole;
import com.example.garageeindopdracht.Services.UserService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#getAllUsers(org.springframework.ui.Model)}
     */
    @Test
    void testGetAllUsers() throws Exception {
        when(this.userService.getAllUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Users");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("users"))
                .andExpect(MockMvcResultMatchers.view().name("User/Users"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("User/Users"));
    }

    /**
     * Method under test: {@link UserController#getAllUsers(org.springframework.ui.Model)}
     */
    @Test
    void testGetAllUsers2() throws Exception {
        when(this.userService.getAllUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/Users");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("users"))
                .andExpect(MockMvcResultMatchers.view().name("User/Users"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("User/Users"));
    }

    /**
     * Method under test: {@link UserController#createUser(org.springframework.ui.Model)}
     */
    @Test
    void testCreateUser() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/User/New");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("User"))
                .andExpect(MockMvcResultMatchers.view().name("User/CreateUser"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("User/CreateUser"));
    }

    /**
     * Method under test: {@link UserController#editUserFinished(com.example.garageeindopdracht.Models.User, long)}
     */
    @Test
    void testEditUserFinished() throws Exception {
        doNothing().when(this.userService).editUser((com.example.garageeindopdracht.Models.User) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/User/{ID}", 1L);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("User"))
                .andExpect(MockMvcResultMatchers.view().name("User/EditUserFinished"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("User/EditUserFinished"));
    }

    /**
     * Method under test: {@link UserController#editUserFinished(com.example.garageeindopdracht.Models.User, long)}
     */
    @Test
    void testEditUserFinished2() throws Exception {
        doNothing().when(this.userService).editUser((com.example.garageeindopdracht.Models.User) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/User/{ID}", 1L);
        postResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("User"))
                .andExpect(MockMvcResultMatchers.view().name("User/EditUserFinished"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("User/EditUserFinished"));
    }

    /**
     * Method under test: {@link UserController#createUser(org.springframework.ui.Model)}
     */
    @Test
    void testCreateUser2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/User/New", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("User"))
                .andExpect(MockMvcResultMatchers.view().name("User/CreateUser"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("User/CreateUser"));
    }

    /**
     * Method under test: {@link UserController#deleteUser(Long, org.springframework.ui.Model)}
     */
    @Test
    void testDeleteUser() throws Exception {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        when(this.userService.getUser(anyLong())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/User/{ID}/Delete", 1L);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.view().name("User/DeleteUser"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("User/DeleteUser"));
    }

    /**
     * Method under test: {@link UserController#deleteUser(Long, org.springframework.ui.Model)}
     */
    @Test
    void testDeleteUser2() throws Exception {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        when(this.userService.getUser(anyLong())).thenReturn(user);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/User/{ID}/Delete", 1L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.view().name("User/DeleteUser"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("User/DeleteUser"));
    }

    /**
     * Method under test: {@link UserController#editUser(Long, org.springframework.ui.Model)}
     */
    @Test
    void testEditUser() throws Exception {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        when(this.userService.getUser(anyLong())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/User/{ID}/Edit", 1L);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("User"))
                .andExpect(MockMvcResultMatchers.view().name("User/EditUser"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("User/EditUser"));
    }

    /**
     * Method under test: {@link UserController#editUser(Long, org.springframework.ui.Model)}
     */
    @Test
    void testEditUser2() throws Exception {
        User user = new User();
        user.setApplicationUserRole(ApplicationUserRole.ADMIN);
        user.setPassword("iloveyou");
        user.setUserID(123L);
        user.setUserName("janedoe");
        when(this.userService.getUser(anyLong())).thenReturn(user);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/User/{ID}/Edit", 1L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("User"))
                .andExpect(MockMvcResultMatchers.view().name("User/EditUser"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("User/EditUser"));
    }

    /**
     * Method under test: {@link UserController#saveUser(com.example.garageeindopdracht.Models.User)}
     */
    @Test
    void testSaveUser() throws Exception {
        doNothing().when(this.userService).newUser((com.example.garageeindopdracht.Models.User) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/User/SaveUser");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("User"))
                .andExpect(MockMvcResultMatchers.view().name("User/SaveUser"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("User/SaveUser"));
    }

    /**
     * Method under test: {@link UserController#saveUser(com.example.garageeindopdracht.Models.User)}
     */
    @Test
    void testSaveUser2() throws Exception {
        doNothing().when(this.userService).newUser((com.example.garageeindopdracht.Models.User) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/User/SaveUser");
        postResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("User"))
                .andExpect(MockMvcResultMatchers.view().name("User/SaveUser"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("User/SaveUser"));
    }
}

