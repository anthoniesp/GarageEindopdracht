package com.example.garageeindopdracht;

import com.example.garageeindopdracht.Controllers.IndexController;
import com.example.garageeindopdracht.Controllers.JobController;
import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Models.User;
import com.example.garageeindopdracht.Security.ApplicationUserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@AutoConfigureMockMvc()
@SpringBootTest
public class JobControllerTest {

    @Autowired
    private MockMvc mockMvc;

    User testUser = createTestUser();

    Job testJob = createTestJob();

    JobController jobController = new JobController();

    @Test
    @WithMockUser(value = "administrative_worker", authorities = "ADMINISTRATIVE_WORKER")
    void shouldReturnAllJobsView() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/Jobs"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("Job/Jobs"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("jobs"));
    }

    @Test
    @WithMockUser(value = "administrative_worker", authorities = "ADMINISTRATIVE_WORKER")
    void shouldReturnCreateJobView() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/Job/New"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("Job/CreateJob"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Job"));
    }

    @Test
    @WithMockUser(value = "administrative_worker", authorities = "ADMINISTRATIVE_WORKER")
    void shouldReturnAllFinishedJobsView() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/Job/FinishedJobs"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("Job/FinishedJobs"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("jobs"));
    }

    @Test
    @WithMockUser(value = "administrative_worker", authorities = "ADMINISTRATIVE_WORKER")
    void shouldReturnAllConcludedJobsView() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/Job/ConcludedJobs"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("Job/ConcludedJobs"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("jobs"));
    }


    public User createTestUser() {
            User user = new User();
            user.setUserName("the_Wolf");
            user.setPassword("RoyaleWithCheese");
            user.setApplicationUserRole(ApplicationUserRole.ADMINISTRATIVE_WORKER);
            return user;
        }

    public Job createTestJob() {
            Job job = new Job();
            job.setCarLicensePlate("LWYRUP");
            job.setCustomerName("Saul Goodman");
            job.setCustomerPhoneNumber("0612369518");
            job.setJobDescription("Better call Saul!");
            return job;
    }

}
