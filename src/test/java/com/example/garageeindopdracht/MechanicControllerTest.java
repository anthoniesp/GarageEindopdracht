package com.example.garageeindopdracht;

import com.example.garageeindopdracht.Controllers.JobController;
import com.example.garageeindopdracht.Controllers.MechanicController;
import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Models.User;
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
public class MechanicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    MechanicController mechanicController = new MechanicController();

    @Test
    @WithMockUser(value = "administrative_worker", authorities = "ADMINISTRATIVE_WORKER")
    void shouldReturnAllActiveJobsView() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/Mechanic/ActiveJobs"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("Mechanic/ActiveJobs"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("jobs"));
    }


}
