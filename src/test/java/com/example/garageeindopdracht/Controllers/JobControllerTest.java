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

@ContextConfiguration(classes = {JobController.class})
@ExtendWith(SpringExtension.class)
class JobControllerTest {
    @Autowired
    private JobController jobController;

    @MockBean
    private JobService jobService;

    /**
     * Method under test: {@link JobController#getAllJobs(org.springframework.ui.Model)}
     */
    @Test
    void testGetAllJobs() throws Exception {
        when(this.jobService.getAllJobs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Jobs");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("jobs"))
                .andExpect(MockMvcResultMatchers.view().name("Job/Jobs"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/Jobs"));
    }

    /**
     * Method under test: {@link JobController#getAllJobs(org.springframework.ui.Model)}
     */
    @Test
    void testGetAllJobs2() throws Exception {
        when(this.jobService.getAllJobs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/Jobs");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("jobs"))
                .andExpect(MockMvcResultMatchers.view().name("Job/Jobs"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/Jobs"));
    }

    /**
     * Method under test: {@link JobController#createJob(org.springframework.ui.Model)}
     */
    @Test
    void testCreateJob() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Job/New");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Job"))
                .andExpect(MockMvcResultMatchers.view().name("Job/CreateJob"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/CreateJob"));
    }

    /**
     * Method under test: {@link JobController#editJobFinished(com.example.garageeindopdracht.Models.Job, long)}
     */
    @Test
    void testEditJobFinished() throws Exception {
        doNothing().when(this.jobService).editJob((com.example.garageeindopdracht.Models.Job) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/Job/{ID}", 1L);
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Job"))
                .andExpect(MockMvcResultMatchers.view().name("Job/EditJobFinished"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/EditJobFinished"));
    }

    /**
     * Method under test: {@link JobController#editJobFinished(com.example.garageeindopdracht.Models.Job, long)}
     */
    @Test
    void testEditJobFinished2() throws Exception {
        doNothing().when(this.jobService).editJob((com.example.garageeindopdracht.Models.Job) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/Job/{ID}", 1L);
        postResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Job"))
                .andExpect(MockMvcResultMatchers.view().name("Job/EditJobFinished"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/EditJobFinished"));
    }

    /**
     * Method under test: {@link JobController#getAllFinishedJobs(org.springframework.ui.Model)}
     */
    @Test
    void testGetAllFinishedJobs() throws Exception {
        when(this.jobService.getAllFinishedJobs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Job/FinishedJobs");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("jobs"))
                .andExpect(MockMvcResultMatchers.view().name("Job/FinishedJobs"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/FinishedJobs"));
    }

    /**
     * Method under test: {@link JobController#getAllFinishedJobs(org.springframework.ui.Model)}
     */
    @Test
    void testGetAllFinishedJobs2() throws Exception {
        when(this.jobService.getAllFinishedJobs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/Job/FinishedJobs");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("jobs"))
                .andExpect(MockMvcResultMatchers.view().name("Job/FinishedJobs"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/FinishedJobs"));
    }

    /**
     * Method under test: {@link JobController#getAllConcludedJobs(org.springframework.ui.Model)}
     */
    @Test
    void testGetAllConcludedJobs() throws Exception {
        when(this.jobService.getAllConcludedJobs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Job/ConcludedJobs");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("jobs"))
                .andExpect(MockMvcResultMatchers.view().name("Job/ConcludedJobs"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/ConcludedJobs"));
    }

    /**
     * Method under test: {@link JobController#getAllConcludedJobs(org.springframework.ui.Model)}
     */
    @Test
    void testGetAllConcludedJobs2() throws Exception {
        when(this.jobService.getAllConcludedJobs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/Job/ConcludedJobs");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("jobs"))
                .andExpect(MockMvcResultMatchers.view().name("Job/ConcludedJobs"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/ConcludedJobs"));
    }

    /**
     * Method under test: {@link JobController#createJob(org.springframework.ui.Model)}
     */
    @Test
    void testCreateJob2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Job/New", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Job"))
                .andExpect(MockMvcResultMatchers.view().name("Job/CreateJob"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/CreateJob"));
    }

    /**
     * Method under test: {@link JobController#deleteJob(Long, org.springframework.ui.Model)}
     */
    @Test
    void testDeleteJob() throws Exception {
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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Job/{ID}/Delete", 1L);
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("job"))
                .andExpect(MockMvcResultMatchers.view().name("Job/DeleteJob"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/DeleteJob"));
    }

    /**
     * Method under test: {@link JobController#deleteJob(Long, org.springframework.ui.Model)}
     */
    @Test
    void testDeleteJob2() throws Exception {
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
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/Job/{ID}/Delete", 1L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("job"))
                .andExpect(MockMvcResultMatchers.view().name("Job/DeleteJob"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/DeleteJob"));
    }

    /**
     * Method under test: {@link JobController#editJob(Long, org.springframework.ui.Model)}
     */
    @Test
    void testEditJob() throws Exception {
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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Job/{ID}/Edit", 1L);
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Job"))
                .andExpect(MockMvcResultMatchers.view().name("Job/EditJob"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/EditJob"));
    }

    /**
     * Method under test: {@link JobController#editJob(Long, org.springframework.ui.Model)}
     */
    @Test
    void testEditJob2() throws Exception {
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
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/Job/{ID}/Edit", 1L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Job"))
                .andExpect(MockMvcResultMatchers.view().name("Job/EditJob"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/EditJob"));
    }

    /**
     * Method under test: {@link JobController#generatePDF(long, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    void testGeneratePDF() throws Exception {
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
        doNothing().when(this.jobService).getReceipt((javax.servlet.http.HttpServletResponse) any(), (Job) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Job/{ID}/Concluded/DownloadReceipt",
                1L);
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/pdf"))
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    /**
     * Method under test: {@link JobController#generatePDF(long, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    void testGeneratePDF2() throws Exception {
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
        doNothing().when(this.jobService).getReceipt((javax.servlet.http.HttpServletResponse) any(), (Job) any());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/Job/{ID}/Concluded/DownloadReceipt", 1L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/pdf"))
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    /**
     * Method under test: {@link JobController#saveJob(com.example.garageeindopdracht.Models.Job)}
     */
    @Test
    void testSaveJob() throws Exception {
        doNothing().when(this.jobService).newJob((com.example.garageeindopdracht.Models.Job) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/Job/SaveJob");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Job"))
                .andExpect(MockMvcResultMatchers.view().name("Job/SaveJob"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/SaveJob"));
    }

    /**
     * Method under test: {@link JobController#saveJob(com.example.garageeindopdracht.Models.Job)}
     */
    @Test
    void testSaveJob2() throws Exception {
        doNothing().when(this.jobService).newJob((com.example.garageeindopdracht.Models.Job) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/Job/SaveJob");
        postResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.jobController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("Job"))
                .andExpect(MockMvcResultMatchers.view().name("Job/SaveJob"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("Job/SaveJob"));
    }
}

