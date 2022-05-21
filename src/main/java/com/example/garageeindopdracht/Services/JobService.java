package com.example.garageeindopdracht.Services;

import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJobs() {
        List<Job> jobList;
        jobList = jobRepository.findAll();
        return jobList;
    }

    public List<Job> getAllActiveJobs() {
        List<Job> jobList;
        int status = 1; // Status 1 staat voor active
        jobList = jobRepository.findByStatus(status);
        return jobList;
    }

    public Job getJob(long ID) {
        return jobRepository.findById(ID).orElse( null);
    }

    public void newJob(Job newJob) {
//        newJob.setID(ID);
        if (jobRepository.findById(newJob.getJobID()).isPresent()) {
//            jobRepository.findById(newJob.getID()).map(
//                    job -> {
//                        job.setCarLicensePlate(newJob.getCarLicensePlate());
//                        job.setCustomerName(newJob.getCustomerName());
//                        job.setCustomerPhoneNumber(newJob.getCustomerPhoneNumber());
//                        job.setJobDescription(newJob.getJobDescription());
//                    }
//            )

        } else {
            jobRepository.save(newJob);
        }
    }

    // https://github.com/V-hofman/huiswerkspring1/blob/extra/huiswerkspring2/src/main/java/com/example/huiswerkspring1/services/AppService.java
    // Copy-pasted
    public void editJob(Job editedJob) {
        //Hier zeggen we stuur iets terug, namelijk zoek een author met een ID
        jobRepository.findById(editedJob.getJobID())
                //Kan je hem vinden? dan doen we een .map, dit overschrijft de author die we vonden
                .map(
                        job -> { //Voor een functie body { } uit en ik verwacht een author terug.
                            //setters van de author die is opgeslagen, die nu de waarde krijgen van de BODY die we in het PUT hadden geplaatst.
                            job.setJobID(editedJob.getJobID());
                            if (editedJob.getCarLicensePlate() != null) {
                                job.setCarLicensePlate(editedJob.getCarLicensePlate());
                                job.setCustomerName(editedJob.getCustomerName());
                                job.setCustomerPhoneNumber(editedJob.getCustomerPhoneNumber());
                                job.setJobDescription(editedJob.getJobDescription());
                            }
                            job.setStatus(editedJob.getStatus());
                            job.setPartsUsedForRepair(editedJob.getPartsUsedForRepair());
                            job.setPartsUsedForRepairPrices(editedJob.getPartsUsedForRepairPrices());
                            //Gegevens veranderd? dan slaan we hem op.
                            return jobRepository.save(job);
                        });
    }


    public void deleteJob(long ID) {
        Job deletingJob = jobRepository.findById(ID).orElse(null);
        if (deletingJob != null) {
            jobRepository.delete(deletingJob);
        }
    }
}
