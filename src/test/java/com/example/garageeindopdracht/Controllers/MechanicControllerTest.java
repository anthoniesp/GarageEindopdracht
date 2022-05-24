package com.example.garageeindopdracht.Controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Services.JobService;

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

@ContextConfiguration(classes = {MechanicController.class})
@ExtendWith(SpringExtension.class)
class MechanicControllerTest {
    @MockBean
    private JobService jobService;

    @Autowired
    private MechanicController mechanicController;

    /**
     * Method under test: {@link MechanicController#editActiveJob(long, org.springframework.ui.Model)}
     */
    @Test
    void testEditActiveJob() throws Exception {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        when(this.jobService.getJob(anyLong())).thenReturn(job);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Mechanic/ActiveJob/{ID}/Edit", 1L);
        MockMvcBuilders.standaloneSetup(this.mechanicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(2))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Job", "Parts"))
                .andExpect(MockMvcResultMatchers.view().name("Mechanic/EditActiveJob"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Mechanic/EditActiveJob"));
    }

    /**
     * Method under test: {@link MechanicController#getAllActiveJobs(org.springframework.ui.Model)}
     */
    @Test
    void testGetAllActiveJobs() throws Exception {
        when(this.jobService.getAllActiveJobs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Mechanic/ActiveJobs");
        MockMvcBuilders.standaloneSetup(this.mechanicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("jobs"))
                .andExpect(MockMvcResultMatchers.view().name("Mechanic/ActiveJobs"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Mechanic/ActiveJobs"));
    }

    /**
     * Method under test: {@link MechanicController#getAllActiveJobs(org.springframework.ui.Model)}
     */
    @Test
    void testGetAllActiveJobs2() throws Exception {
        when(this.jobService.getAllActiveJobs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/Mechanic/ActiveJobs");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.mechanicController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("jobs"))
                .andExpect(MockMvcResultMatchers.view().name("Mechanic/ActiveJobs"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Mechanic/ActiveJobs"));
    }

    /**
     * Method under test: {@link MechanicController#editActiveJob(long, org.springframework.ui.Model)}
     */
    @Test
    void testEditActiveJob2() throws Exception {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        when(this.jobService.getJob(anyLong())).thenReturn(job);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/Mechanic/ActiveJob/{ID}/Edit", 1L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.mechanicController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(2))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Job", "Parts"))
                .andExpect(MockMvcResultMatchers.view().name("Mechanic/EditActiveJob"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Mechanic/EditActiveJob"));
    }

    /**
     * Method under test: {@link MechanicController#editActiveJobFinished(com.example.garageeindopdracht.Models.Job, long, String, String)}
     */
    @Test
    void testEditActiveJobFinished() throws Exception {
        doNothing().when(this.jobService).editJob((com.example.garageeindopdracht.Models.Job) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/Mechanic/ActiveJob/{ID}/Edit/Finished", 1L)
                .param("part", "foo")
                .param("partPrice", "foo");
        MockMvcBuilders.standaloneSetup(this.mechanicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Job"))
                .andExpect(MockMvcResultMatchers.view().name("Mechanic/EditActiveJobFinished"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Mechanic/EditActiveJobFinished"));
    }

    /**
     * Method under test: {@link MechanicController#editActiveJobFinished(com.example.garageeindopdracht.Models.Job, long, String, String)}
     */
    @Test
    void testEditActiveJobFinished2() throws Exception {
        doNothing().when(this.jobService).editJob((com.example.garageeindopdracht.Models.Job) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/Mechanic/ActiveJob/{ID}/Edit/Finished",
                1L);
        postResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = postResult.param("part", "foo").param("partPrice", "foo");
        MockMvcBuilders.standaloneSetup(this.mechanicController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Job"))
                .andExpect(MockMvcResultMatchers.view().name("Mechanic/EditActiveJobFinished"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Mechanic/EditActiveJobFinished"));
    }
}

