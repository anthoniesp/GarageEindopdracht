package com.example.garageeindopdracht.Controllers;

import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Models.Part;
import com.example.garageeindopdracht.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MechanicController {

    @Autowired
    JobService jobService;

    @GetMapping("/Mechanic/ActiveJobs")
    public String getAllActiveJobs(Model model) {
        List<Job> jobList = jobService.getAllActiveJobs();
        model.addAttribute("jobs", jobList);
        return "Mechanic/ActiveJobs"; // "ActiveJobs" verwijst naar ActiveJobs.html
    }

    @GetMapping("/Mechanic/ActiveJob/{ID}/Edit")
    public String editActiveJob(@PathVariable long ID, Model model) {
        Job existingJob = jobService.getJob(ID);
        model.addAttribute("Job", existingJob);
        model.addAttribute("Parts", existingJob.getAllParts());
        return "Mechanic/EditActiveJob";
    }

    @PostMapping("/Mechanic/ActiveJob/{ID}/Edit/Finished")
    public String editActiveJobFinished(@ModelAttribute("Job") Job editedJob, @PathVariable("ID") long ID, @RequestParam("part") String part, @RequestParam("partPrice") String partPrice) {
        editedJob.setJobID(ID);
        editedJob.addPartToString(part);
        editedJob.addPartPriceToString(partPrice);
        jobService.editJob(editedJob);
        return "Mechanic/EditActiveJobFinished";
    }

}
