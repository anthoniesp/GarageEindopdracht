package com.example.garageeindopdracht.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Repositories.JobRepository;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JobService.class})
@ExtendWith(SpringExtension.class)
class JobServiceTest {
    @MockBean
    private JobRepository jobRepository;

    @Autowired
    private JobService jobService;

    /**
     * Method under test: {@link JobService#getAllJobs()}
     */
    @Test
    void testGetAllJobs() {
        ArrayList<Job> jobList = new ArrayList<>();
        when(this.jobRepository.findAll()).thenReturn(jobList);
        List<Job> actualAllJobs = this.jobService.getAllJobs();
        assertSame(jobList, actualAllJobs);
        assertTrue(actualAllJobs.isEmpty());
        verify(this.jobRepository).findAll();
    }

    /**
     * Method under test: {@link JobService#getAllActiveJobs()}
     */
    @Test
    void testGetAllActiveJobs() {
        ArrayList<Job> jobList = new ArrayList<>();
        when(this.jobRepository.findByStatus(anyInt())).thenReturn(jobList);
        List<Job> actualAllActiveJobs = this.jobService.getAllActiveJobs();
        assertSame(jobList, actualAllActiveJobs);
        assertTrue(actualAllActiveJobs.isEmpty());
        verify(this.jobRepository).findByStatus(anyInt());
    }

    /**
     * Method under test: {@link JobService#getAllFinishedJobs()}
     */
    @Test
    void testGetAllFinishedJobs() {
        ArrayList<Job> jobList = new ArrayList<>();
        when(this.jobRepository.findByStatus(anyInt())).thenReturn(jobList);
        List<Job> actualAllFinishedJobs = this.jobService.getAllFinishedJobs();
        assertSame(jobList, actualAllFinishedJobs);
        assertTrue(actualAllFinishedJobs.isEmpty());
        verify(this.jobRepository).findByStatus(anyInt());
    }

    /**
     * Method under test: {@link JobService#getAllConcludedJobs()}
     */
    @Test
    void testGetAllConcludedJobs() {
        ArrayList<Job> jobList = new ArrayList<>();
        when(this.jobRepository.findByStatus(anyInt())).thenReturn(jobList);
        List<Job> actualAllConcludedJobs = this.jobService.getAllConcludedJobs();
        assertSame(jobList, actualAllConcludedJobs);
        assertTrue(actualAllConcludedJobs.isEmpty());
        verify(this.jobRepository).findByStatus(anyInt());
    }

    /**
     * Method under test: {@link JobService#getJob(long)}
     */
    @Test
    void testGetJob() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        Optional<Job> ofResult = Optional.of(job);
        when(this.jobRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(job, this.jobService.getJob(1L));
        verify(this.jobRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link JobService#newJob(Job)}
     */
    @Test
    void testNewJob() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);

        Job job1 = new Job();
        job1.setCarLicensePlate("Car License Plate");
        job1.setCustomerName("Customer Name");
        job1.setCustomerPhoneNumber("4105551212");
        job1.setJobDescription("Job Description");
        job1.setJobID(1L);
        job1.setPartsUsedForRepair("Parts Used For Repair");
        job1.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job1.setStatus(1);
        Optional<Job> ofResult = Optional.of(job1);
        when(this.jobRepository.save((Job) any())).thenReturn(job);
        when(this.jobRepository.findById((Long) any())).thenReturn(ofResult);

        Job job2 = new Job();
        job2.setCarLicensePlate("Car License Plate");
        job2.setCustomerName("Customer Name");
        job2.setCustomerPhoneNumber("4105551212");
        job2.setJobDescription("Job Description");
        job2.setJobID(1L);
        job2.setPartsUsedForRepair("Parts Used For Repair");
        job2.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job2.setStatus(1);
        this.jobService.newJob(job2);
        verify(this.jobRepository).findById((Long) any());
        assertEquals("Active", job2.getStatusToString());
        assertEquals("Car License Plate", job2.getCarLicensePlate());
        assertEquals("Parts Used For Repair Prices", job2.getPartsUsedForRepairPrices());
        assertEquals("Parts Used For Repair", job2.getPartsUsedForRepair());
        assertEquals("4105551212", job2.getCustomerPhoneNumber());
        assertEquals(1L, job2.getJobID());
        assertEquals("Job Description", job2.getJobDescription());
        assertEquals("Customer Name", job2.getCustomerName());
        assertTrue(this.jobService.getAllActiveJobs().isEmpty());
    }

    /**
     * Method under test: {@link JobService#newJob(Job)}
     */
    @Test
    void testNewJob2() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        when(this.jobRepository.save((Job) any())).thenReturn(job);
        when(this.jobRepository.findById((Long) any())).thenReturn(Optional.empty());

        Job job1 = new Job();
        job1.setCarLicensePlate("Car License Plate");
        job1.setCustomerName("Customer Name");
        job1.setCustomerPhoneNumber("4105551212");
        job1.setJobDescription("Job Description");
        job1.setJobID(1L);
        job1.setPartsUsedForRepair("Parts Used For Repair");
        job1.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job1.setStatus(1);
        this.jobService.newJob(job1);
        verify(this.jobRepository).save((Job) any());
        verify(this.jobRepository).findById((Long) any());
        assertEquals("Active", job1.getStatusToString());
        assertEquals("Car License Plate", job1.getCarLicensePlate());
        assertEquals("Parts Used For Repair Prices", job1.getPartsUsedForRepairPrices());
        assertEquals("Parts Used For Repair", job1.getPartsUsedForRepair());
        assertEquals("4105551212", job1.getCustomerPhoneNumber());
        assertEquals(1L, job1.getJobID());
        assertEquals("Job Description", job1.getJobDescription());
        assertEquals("Customer Name", job1.getCustomerName());
        assertTrue(this.jobService.getAllActiveJobs().isEmpty());
    }

    /**
     * Method under test: {@link JobService#editJob(Job)}
     */
    @Test
    void testEditJob() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        Optional<Job> ofResult = Optional.of(job);

        Job job1 = new Job();
        job1.setCarLicensePlate("Car License Plate");
        job1.setCustomerName("Customer Name");
        job1.setCustomerPhoneNumber("4105551212");
        job1.setJobDescription("Job Description");
        job1.setJobID(1L);
        job1.setPartsUsedForRepair("Parts Used For Repair");
        job1.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job1.setStatus(1);
        when(this.jobRepository.save((Job) any())).thenReturn(job1);
        when(this.jobRepository.findById((Long) any())).thenReturn(ofResult);

        Job job2 = new Job();
        job2.setCarLicensePlate("Car License Plate");
        job2.setCustomerName("Customer Name");
        job2.setCustomerPhoneNumber("4105551212");
        job2.setJobDescription("Job Description");
        job2.setJobID(1L);
        job2.setPartsUsedForRepair("Parts Used For Repair");
        job2.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job2.setStatus(1);
        this.jobService.editJob(job2);
        verify(this.jobRepository).save((Job) any());
        verify(this.jobRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link JobService#editJob(Job)}
     */
    @Test
    void testEditJob2() {
        Job job = mock(Job.class);
        when(job.getPartsUsedForRepairPrices()).thenReturn("Parts Used For Repair Prices");
        when(job.getPartsUsedForRepair()).thenReturn("foo");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        Optional<Job> ofResult = Optional.of(job);

        Job job1 = new Job();
        job1.setCarLicensePlate("Car License Plate");
        job1.setCustomerName("Customer Name");
        job1.setCustomerPhoneNumber("4105551212");
        job1.setJobDescription("Job Description");
        job1.setJobID(1L);
        job1.setPartsUsedForRepair("Parts Used For Repair");
        job1.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job1.setStatus(1);
        when(this.jobRepository.save((Job) any())).thenReturn(job1);
        when(this.jobRepository.findById((Long) any())).thenReturn(ofResult);

        Job job2 = new Job();
        job2.setCarLicensePlate("Car License Plate");
        job2.setCustomerName("Customer Name");
        job2.setCustomerPhoneNumber("4105551212");
        job2.setJobDescription("Job Description");
        job2.setJobID(1L);
        job2.setPartsUsedForRepair("Parts Used For Repair");
        job2.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job2.setStatus(1);
        this.jobService.editJob(job2);
        verify(this.jobRepository).save((Job) any());
        verify(this.jobRepository).findById((Long) any());
        verify(job, atLeast(1)).getPartsUsedForRepair();
        verify(job).getPartsUsedForRepairPrices();
        verify(job, atLeast(1)).setCarLicensePlate((String) any());
        verify(job, atLeast(1)).setCustomerName((String) any());
        verify(job, atLeast(1)).setCustomerPhoneNumber((String) any());
        verify(job, atLeast(1)).setJobDescription((String) any());
        verify(job, atLeast(1)).setJobID(anyLong());
        verify(job, atLeast(1)).setPartsUsedForRepair((String) any());
        verify(job, atLeast(1)).setPartsUsedForRepairPrices((String) any());
        verify(job, atLeast(1)).setStatus(anyInt());
    }

    /**
     * Method under test: {@link JobService#editJob(Job)}
     */
    @Test
    void testEditJob3() {
        Job job = mock(Job.class);
        when(job.getPartsUsedForRepairPrices()).thenReturn("Parts Used For Repair Prices");
        when(job.getPartsUsedForRepair()).thenReturn(null);
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        Optional<Job> ofResult = Optional.of(job);

        Job job1 = new Job();
        job1.setCarLicensePlate("Car License Plate");
        job1.setCustomerName("Customer Name");
        job1.setCustomerPhoneNumber("4105551212");
        job1.setJobDescription("Job Description");
        job1.setJobID(1L);
        job1.setPartsUsedForRepair("Parts Used For Repair");
        job1.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job1.setStatus(1);
        when(this.jobRepository.save((Job) any())).thenReturn(job1);
        when(this.jobRepository.findById((Long) any())).thenReturn(ofResult);

        Job job2 = new Job();
        job2.setCarLicensePlate("Car License Plate");
        job2.setCustomerName("Customer Name");
        job2.setCustomerPhoneNumber("4105551212");
        job2.setJobDescription("Job Description");
        job2.setJobID(1L);
        job2.setPartsUsedForRepair("Parts Used For Repair");
        job2.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job2.setStatus(1);
        this.jobService.editJob(job2);
        verify(this.jobRepository).save((Job) any());
        verify(this.jobRepository).findById((Long) any());
        verify(job).getPartsUsedForRepair();
        verify(job, atLeast(1)).setCarLicensePlate((String) any());
        verify(job, atLeast(1)).setCustomerName((String) any());
        verify(job, atLeast(1)).setCustomerPhoneNumber((String) any());
        verify(job, atLeast(1)).setJobDescription((String) any());
        verify(job, atLeast(1)).setJobID(anyLong());
        verify(job, atLeast(1)).setPartsUsedForRepair((String) any());
        verify(job, atLeast(1)).setPartsUsedForRepairPrices((String) any());
        verify(job, atLeast(1)).setStatus(anyInt());
    }

    /**
     * Method under test: {@link JobService#editJob(Job)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditJob4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.map(java.util.function.Function)" because the return value of "com.example.garageeindopdracht.Repositories.JobRepository.findById(Object)" is null
        //       at com.example.garageeindopdracht.Services.JobService.editJob(JobService.java:76)
        //   In order to prevent editJob(Job)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   editJob(Job).
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        when(this.jobRepository.save((Job) any())).thenReturn(job);
        when(this.jobRepository.findById((Long) any())).thenReturn(null);
        Job job1 = mock(Job.class);
        when(job1.getPartsUsedForRepairPrices()).thenReturn("Parts Used For Repair Prices");
        when(job1.getPartsUsedForRepair()).thenReturn("foo");
        doNothing().when(job1).setCarLicensePlate((String) any());
        doNothing().when(job1).setCustomerName((String) any());
        doNothing().when(job1).setCustomerPhoneNumber((String) any());
        doNothing().when(job1).setJobDescription((String) any());
        doNothing().when(job1).setJobID(anyLong());
        doNothing().when(job1).setPartsUsedForRepair((String) any());
        doNothing().when(job1).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job1).setStatus(anyInt());
        job1.setCarLicensePlate("Car License Plate");
        job1.setCustomerName("Customer Name");
        job1.setCustomerPhoneNumber("4105551212");
        job1.setJobDescription("Job Description");
        job1.setJobID(1L);
        job1.setPartsUsedForRepair("Parts Used For Repair");
        job1.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job1.setStatus(1);

        Job job2 = new Job();
        job2.setCarLicensePlate("Car License Plate");
        job2.setCustomerName("Customer Name");
        job2.setCustomerPhoneNumber("4105551212");
        job2.setJobDescription("Job Description");
        job2.setJobID(1L);
        job2.setPartsUsedForRepair("Parts Used For Repair");
        job2.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job2.setStatus(1);
        this.jobService.editJob(job2);
    }

    /**
     * Method under test: {@link JobService#editJob(Job)}
     */
    @Test
    void testEditJob5() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        when(this.jobRepository.save((Job) any())).thenReturn(job);
        when(this.jobRepository.findById((Long) any())).thenReturn(Optional.empty());
        Job job1 = mock(Job.class);
        when(job1.getPartsUsedForRepairPrices()).thenReturn("Parts Used For Repair Prices");
        when(job1.getPartsUsedForRepair()).thenReturn("foo");
        doNothing().when(job1).setCarLicensePlate((String) any());
        doNothing().when(job1).setCustomerName((String) any());
        doNothing().when(job1).setCustomerPhoneNumber((String) any());
        doNothing().when(job1).setJobDescription((String) any());
        doNothing().when(job1).setJobID(anyLong());
        doNothing().when(job1).setPartsUsedForRepair((String) any());
        doNothing().when(job1).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job1).setStatus(anyInt());
        job1.setCarLicensePlate("Car License Plate");
        job1.setCustomerName("Customer Name");
        job1.setCustomerPhoneNumber("4105551212");
        job1.setJobDescription("Job Description");
        job1.setJobID(1L);
        job1.setPartsUsedForRepair("Parts Used For Repair");
        job1.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job1.setStatus(1);

        Job job2 = new Job();
        job2.setCarLicensePlate("Car License Plate");
        job2.setCustomerName("Customer Name");
        job2.setCustomerPhoneNumber("4105551212");
        job2.setJobDescription("Job Description");
        job2.setJobID(1L);
        job2.setPartsUsedForRepair("Parts Used For Repair");
        job2.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job2.setStatus(1);
        this.jobService.editJob(job2);
        verify(this.jobRepository).findById((Long) any());
        verify(job1).setCarLicensePlate((String) any());
        verify(job1).setCustomerName((String) any());
        verify(job1).setCustomerPhoneNumber((String) any());
        verify(job1).setJobDescription((String) any());
        verify(job1).setJobID(anyLong());
        verify(job1).setPartsUsedForRepair((String) any());
        verify(job1).setPartsUsedForRepairPrices((String) any());
        verify(job1).setStatus(anyInt());
        assertEquals("Active", job2.getStatusToString());
        assertEquals("Car License Plate", job2.getCarLicensePlate());
        assertEquals("Parts Used For Repair Prices", job2.getPartsUsedForRepairPrices());
        assertEquals("Parts Used For Repair", job2.getPartsUsedForRepair());
        assertEquals("4105551212", job2.getCustomerPhoneNumber());
        assertEquals(1L, job2.getJobID());
        assertEquals("Job Description", job2.getJobDescription());
        assertEquals("Customer Name", job2.getCustomerName());
        assertTrue(this.jobService.getAllActiveJobs().isEmpty());
    }

    /**
     * Method under test: {@link JobService#deleteJob(long)}
     */
    @Test
    void testDeleteJob() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        Optional<Job> ofResult = Optional.of(job);
        doNothing().when(this.jobRepository).delete((Job) any());
        when(this.jobRepository.findById((Long) any())).thenReturn(ofResult);
        this.jobService.deleteJob(1L);
        verify(this.jobRepository).findById((Long) any());
        verify(this.jobRepository).delete((Job) any());
        assertTrue(this.jobService.getAllActiveJobs().isEmpty());
    }

    /**
     * Method under test: {@link JobService#deleteJob(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteJob2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.orElse(Object)" because the return value of "com.example.garageeindopdracht.Repositories.JobRepository.findById(Object)" is null
        //       at com.example.garageeindopdracht.Services.JobService.deleteJob(JobService.java:101)
        //   In order to prevent deleteJob(long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deleteJob(long).
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(this.jobRepository).delete((Job) any());
        when(this.jobRepository.findById((Long) any())).thenReturn(null);
        this.jobService.deleteJob(1L);
    }

    /**
     * Method under test: {@link JobService#deleteJob(long)}
     */
    @Test
    void testDeleteJob3() {
        doNothing().when(this.jobRepository).delete((Job) any());
        when(this.jobRepository.findById((Long) any())).thenReturn(Optional.empty());
        this.jobService.deleteJob(1L);
        verify(this.jobRepository).findById((Long) any());
        assertTrue(this.jobService.getAllActiveJobs().isEmpty());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetReceipt() throws DocumentException, IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Parts Used For Repair Prices"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //       at com.example.garageeindopdracht.Services.JobService.getReceipt(JobService.java:126)
        //   In order to prevent getReceipt(HttpServletResponse, Job)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getReceipt(HttpServletResponse, Job).
        //   See https://diff.blue/R013 to resolve this issue.

        Response response = new Response();

        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(response, job);
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetReceipt2() throws DocumentException, IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Parts Used For Repair Prices"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //       at com.example.garageeindopdracht.Services.JobService.getReceipt(JobService.java:126)
        //   In order to prevent getReceipt(HttpServletResponse, Job)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getReceipt(HttpServletResponse, Job).
        //   See https://diff.blue/R013 to resolve this issue.

        Response response = new Response(3);

        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(response, job);
    }

    /**
     * Method under test: {@link JobService#getReceipt(HttpServletResponse, Job)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetReceipt3() throws DocumentException, IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "javax.servlet.http.HttpServletResponse.getOutputStream()" because "response" is null
        //       at com.example.garageeindopdracht.Services.JobService.getReceipt(JobService.java:109)
        //   In order to prevent getReceipt(HttpServletResponse, Job)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getReceipt(HttpServletResponse, Job).
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(null, job);
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetReceipt4() throws DocumentException, IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.apache.coyote.Response.getWriteListener()" because "this.coyoteResponse" is null
        //       at org.apache.catalina.connector.OutputBuffer.isBlocking(OutputBuffer.java:665)
        //       at org.apache.catalina.connector.CoyoteOutputStream.checkNonBlockingWrite(CoyoteOutputStream.java:134)
        //       at org.apache.catalina.connector.CoyoteOutputStream.write(CoyoteOutputStream.java:95)
        //       at java.io.BufferedOutputStream.flushBuffer(BufferedOutputStream.java:81)
        //       at java.io.BufferedOutputStream.flush(BufferedOutputStream.java:142)
        //       at com.itextpdf.text.pdf.OutputStreamCounter.flush(OutputStreamCounter.java:89)
        //       at com.itextpdf.text.DocWriter.close(DocWriter.java:233)
        //       at com.itextpdf.text.pdf.PdfWriter.close(PdfWriter.java:1341)
        //       at com.itextpdf.text.pdf.PdfDocument.close(PdfDocument.java:901)
        //       at com.itextpdf.text.Document.close(Document.java:415)
        //       at com.example.garageeindopdracht.Services.JobService.getReceipt(JobService.java:132)
        //   In order to prevent getReceipt(HttpServletResponse, Job)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getReceipt(HttpServletResponse, Job).
        //   See https://diff.blue/R013 to resolve this issue.

        Response response = new Response();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("All Parts And Prices As String");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(response, job);
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt5() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("All Parts And Prices As String");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt6() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt7() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("All Parts And Prices As String");
        when(job.getCarLicensePlate()).thenReturn("\t");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt8() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("All Parts And Prices As String");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("\t");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt9() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("\t");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt10() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Helvetica-Bold");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt11() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Autogarage de Vastloper");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt12() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("\n\n");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt13() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Helvetica");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt14() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("foo");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt15() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("java.lang.String");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt16() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("42");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt17() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("java.util.List");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt18() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("");
        when(job.getCustomerName()).thenReturn("Customer Name");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt19() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("\t");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt20() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("Helvetica-Bold");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt21() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("Autogarage de Vastloper");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt22() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("\n\n");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt23() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("Helvetica");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt24() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("foo");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt25() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("java.lang.String");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt26() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("42");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt27() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("java.util.List");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }

    /**
     * Method under test: {@link JobService#getReceipt(javax.servlet.http.HttpServletResponse, Job)}
     */
    @Test
    void testGetReceipt28() throws DocumentException, IOException {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        Job job = mock(Job.class);
        when(job.getAllPartsAndPricesAsString()).thenReturn("\t");
        when(job.getCarLicensePlate()).thenReturn("Car License Plate");
        when(job.getCustomerName()).thenReturn("");
        doNothing().when(job).setCarLicensePlate((String) any());
        doNothing().when(job).setCustomerName((String) any());
        doNothing().when(job).setCustomerPhoneNumber((String) any());
        doNothing().when(job).setJobDescription((String) any());
        doNothing().when(job).setJobID(anyLong());
        doNothing().when(job).setPartsUsedForRepair((String) any());
        doNothing().when(job).setPartsUsedForRepairPrices((String) any());
        doNothing().when(job).setStatus(anyInt());
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        this.jobService.getReceipt(mockHttpServletResponse, job);
        verify(job).getAllPartsAndPricesAsString();
        verify(job).getCarLicensePlate();
        verify(job).getCustomerName();
        verify(job).setCarLicensePlate((String) any());
        verify(job).setCustomerName((String) any());
        verify(job).setCustomerPhoneNumber((String) any());
        verify(job).setJobDescription((String) any());
        verify(job).setJobID(anyLong());
        verify(job).setPartsUsedForRepair((String) any());
        verify(job).setPartsUsedForRepairPrices((String) any());
        verify(job).setStatus(anyInt());
        assertTrue(mockHttpServletResponse.isCommitted());
    }
}

