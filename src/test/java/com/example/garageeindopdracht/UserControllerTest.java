package com.example.garageeindopdracht;


import com.example.garageeindopdracht.Controllers.JobController;
import com.example.garageeindopdracht.Controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc()
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    UserController userController = new UserController();

    @Test
    @WithMockUser(value = "admin", authorities = "ADMIN")
    void shouldReturnNewUserView() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/User/New"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("User/CreateUser"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("User"));
    }

    @Test
    @WithMockUser(value = "admin", authorities = "ADMIN")
    void shouldReturnAllUsersView() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/Users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("User/Users"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("users"));
    }

    @Test
    @WithMockUser(value = "admin", authorities = "ADMIN")
    void shouldReturnSaveUserView() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/User/SaveUser"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("User/SaveUser"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("User"));
    }


}
