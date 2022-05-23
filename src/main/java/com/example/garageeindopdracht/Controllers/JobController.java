package com.example.garageeindopdracht.Controllers;

import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Services.JobService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        return "Job/Jobs"; // "Jobs" verwijst naar Jobs.html
    }

//    // Vraag een specifieke job op -zonder webinterface
//    @GetMapping("/Job/{ID}")
//    private Job getJob(@PathVariable("ID") long ID) {
//        return jobService.getJob(ID);
//    }

    // Maak een nieuwe job aan -met web interface
    @GetMapping("/Job/New")
    public String createJob(Model model) {
        Job newJob = new Job();
        model.addAttribute("Job", newJob);
        return "Job/CreateJob";
    }

    // Get methode voor de web-interface van de Edit methode
    @GetMapping("/Job/{ID}/Edit")
    public String editJob(@PathVariable Long ID, Model model) {
        Job existingJob = jobService.getJob(ID);
        model.addAttribute("Job", existingJob);
        return "Job/EditJob";
    }

    // Sla aangemaakte job op in de database
    @PostMapping("/Job/SaveJob")
    public String saveJob(@ModelAttribute("Job") Job newJob) {
        jobService.newJob(newJob);
        return "Job/SaveJob";
    }

    // Pas een bestaande job aan
    @PostMapping("/Job/{ID}")
    public String editJobFinished(@ModelAttribute("Job") Job editedJob, @PathVariable("ID") long ID) {
        editedJob.setJobID(ID);
        // Onderstaande methode checkt of de job al bestaat, zo niet, dan maakt die een nieuwe aan
        jobService.editJob(editedJob);
        return "Job/EditJobFinished";
    }

    // Get methode om een job te verwijderen
    @GetMapping("/Job/{ID}/Delete")
    public String deleteJob(@PathVariable Long ID, Model model) {
        Job deletingJob = jobService.getJob(ID);
        model.addAttribute("job", deletingJob);
        return "Job/DeleteJob";
    }

    // Verwijder een job
    @PostMapping("/Job/{ID}/Deleted")
    private String deleteJobFinished(@PathVariable long ID){
        jobService.deleteJob(ID);
        return "Job/DeleteJobFinished";
    }

    @GetMapping("/Job/FinishedJobs")
    public String getAllFinishedJobs(Model model) {
        List<Job> jobList = jobService.getAllFinishedJobs();
        model.addAttribute("jobs", jobList);
        return "Job/FinishedJobs";
    }

    @GetMapping("/Job/ConcludedJobs")
    public String getAllConcludedJobs(Model model) {
        List<Job> jobList = jobService.getAllConcludedJobs();
        model.addAttribute("jobs", jobList);
        return "Job/ConcludedJobs";
    }

    @GetMapping("/Job/Finished/{ID}/Conclude")
    private String concludeJob(@PathVariable long ID, Model model) {
        Job job = jobService.getJob(ID);
        model.addAttribute("job", job);
        return "Job/ConcludeJob";
    }

    @GetMapping("/Job/{ID}/Concluded")
    private String concludeJobFinished(@ModelAttribute("Job") Job concludedJob, @PathVariable long ID, Model model) {
        Job job = jobService.getJob(ID);
        job.setStatus(3);
        jobService.editJob(job);
        model.addAttribute("job", job);
        return "Job/ConcludeJobFinished";
    }

    @GetMapping("/Job/{ID}/Concluded/DownloadReceipt")
    public void generatePDF(@PathVariable long ID, HttpServletResponse response) throws IOException, DocumentException {
        Job job = jobService.getJob(ID);
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.jobService.getReceipt(response, job);
    }
}