package com.example.garageeindopdracht.Controllers;

import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
