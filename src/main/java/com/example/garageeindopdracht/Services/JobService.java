package com.example.garageeindopdracht.Services;

import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJobs() {
        List<Job> jobList;
        jobList = jobRepository.findAll();
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
                //TODO            job.setName(editedJob.getName());
                //TODO            job.setMembershipLevel(editedJob.getMembershipLevel());
                            //Gegevens veranderd? dan slaan we hem op.
                            return jobRepository.save(job);
                        }).orElseGet(() -> { //Kan je hem niet vinden? Dan slaan we in dit geval gewoon een nieuwe op.
                    editedJob.setJobID(editedJob.getJobID());
                    return jobRepository.save(editedJob);
                });
    }

    public void deleteJob(long ID) {
        Job deletingJob = jobRepository.findById(ID).orElse(null);
        if (deletingJob != null) {
            jobRepository.delete(deletingJob);
        }
    }
}
