package com.example.garageeindopdracht.Services;

import com.example.garageeindopdracht.Models.Job;
import com.example.garageeindopdracht.Repositories.JobRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    public List<Job> getAllActiveJobs() {
        List<Job> jobList;
        int status = 1; // Status 1 staat voor active
        jobList = jobRepository.findByStatus(status);
        return jobList;
    }

    public List<Job> getAllFinishedJobs() {
        List<Job> jobList;
        int status = 2; // Status 2 staat voor finished
        jobList = jobRepository.findByStatus(status);
        return jobList;
    }

    public List<Job> getAllConcludedJobs() {
        List<Job> jobList;
        int status = 3; // Status 3 staat voor concluded
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
                            if (job.getPartsUsedForRepair() != null && job.getPartsUsedForRepair() != editedJob.getPartsUsedForRepair()) {
                                job.setPartsUsedForRepair(job.getPartsUsedForRepair() + editedJob.getPartsUsedForRepair());
                                job.setPartsUsedForRepairPrices(job.getPartsUsedForRepairPrices() + editedJob.getPartsUsedForRepairPrices());
                            } else {
                                job.setPartsUsedForRepair(editedJob.getPartsUsedForRepair());
                                job.setPartsUsedForRepairPrices(editedJob.getPartsUsedForRepairPrices());
                            }
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

    public void getReceipt(HttpServletResponse response, Job job) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph title = new Paragraph("Autogarage de Vastloper", fontTitle);
        title.setAlignment(Paragraph.ALIGN_CENTER);

        Paragraph whiteLines = new Paragraph("\n" + "\n", fontTitle);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph = new Paragraph(
                "License plate: " + job.getCarLicensePlate() + "\n" +
                "Name: " + job.getCustomerName() + "\n" + "\n" + "\n"
                + job.getAllPartsAndPricesAsString());
        paragraph.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(title);
        document.add(whiteLines);
        document.add(paragraph);
        document.close();
    }
}
