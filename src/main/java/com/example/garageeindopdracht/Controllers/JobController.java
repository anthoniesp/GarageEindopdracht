package com.example.garageeindopdracht.Controllers;

import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    JobService jobService;

    // vraag een lijst met alle jobs op  ->  implementeert
    @GetMapping("/Jobs")
    public String getAllJobs(Model model) {
        List<Job> jobList = jobService.getAllJobs();
        model.addAttribute("jobs", jobList);
        return "Jobs"; // "Jobs" verwijst naar Jobs.html
    }

    // Vraag een specifieke job op -zonder webinterface
    @GetMapping("/Job/{ID}")
    private Job getJob(@PathVariable("ID") long ID) {
        return jobService.getJob(ID);
    }

    // Maak een nieuwe job aan -met web interface TODO
    @GetMapping("/Job/New")
    public String createJob(Model model) {
        Job newJob = new Job();
        model.addAttribute("Job", newJob);
        return "CreateJob";
    }

    // Get methode voor de web-interface van de Edit methode
    @GetMapping("/Job/{ID}/Edit")
    public String editJob(@PathVariable Long ID, Model model) {
        Job existingJob = jobService.getJob(ID);
        model.addAttribute("Job", existingJob);
        return "editJob";
    }

    // Sla aangemaakte job op in de database
    @PostMapping("/SaveJob")
    public String saveJob(@ModelAttribute("Job") Job newJob) {
        jobService.newJob(newJob);
        return "SaveJob";
    }

    // Pas een bestaande job aan
    @PostMapping("/Job/{ID}")
    public String editJobFinished(@ModelAttribute("Job") Job editedJob) {
        // Onderstaande methode checkt of de job al bestaat, zo niet, dan maakt die een nieuwe aan
        jobService.editJob(editedJob);
        return "EditJobFinished";
    }

    // Get methode om een job te verwijderen
    @GetMapping("/Job/{ID}/Delete")
    public String deleteJob(@PathVariable Long ID, Model model) {
        Job deletingJob = jobService.getJob(ID);
        model.addAttribute("job", deletingJob);
        return "DeleteJob";
    }

    // Verwijder een job
    @PostMapping("/Job/{ID}/Deleted")
    private String deleteJobFinished(@PathVariable long ID){
        jobService.deleteJob(ID);
        return "DeleteJobFinished";
    }


}