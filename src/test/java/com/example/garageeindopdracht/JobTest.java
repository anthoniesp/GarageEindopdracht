package com.example.garageeindopdracht;

import com.example.garageeindopdracht.Models.Job;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JobTest {


    Job testJob = createTestJob();

    @Test
    public void getJobIDTest() {
        testJob.setJobID(69);
        assertEquals(69, testJob.getJobID());
    }

    @Test
    public void getStatusTest() {
        testJob.setStatus(1);
        assertEquals(1, testJob.getStatus());
    }

    @Test
    public void getCustomerNameTest() {
        assertEquals("Saul Goodman", testJob.getCustomerName());
    }

    @Test
    public void getCustomerPhoneNumberTest() {
        assertEquals("0612369518", testJob.getCustomerPhoneNumber());
    }

    @Test
    public void getCarLicensePlateTest() {
        assertEquals("LWYRUP", testJob.getCarLicensePlate());
    }

    @Test
    public void getJobDescriptionTest() {
        assertEquals("Better call Saul!", testJob.getJobDescription());
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
