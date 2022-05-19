package com.example.garageeindopdracht.Models;

import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "jobsTable")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long jobID;
    @Column
    private String carLicensePlate;
    @Column
    private int status;
    @Column
    private String customerName;
    @Column
    private String customerPhoneNumber;
    @Column
    private String jobDescription;
    @Column
    private String partsUsedForRepair;
    @Column
    private String partsUsedForRepairPrices;

    public Job(String carLicensePlate, String customerName, String customerPhoneNumber, String jobDescription, int status) {
        this.carLicensePlate = carLicensePlate;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.jobDescription = jobDescription;
        this.status = status;

    }

    public Job() {
    }


    // Voegt een part toe aan de String
    public void addPartToString(String newPart) {
        partsUsedForRepair = partsUsedForRepair + ";" + newPart;
    }

    // TODO
    // Voegt een prijs toe aan de String
    public void addPartPriceToString(String newPartPrice) {
        partsUsedForRepairPrices = partsUsedForRepairPrices + ";" + newPartPrice;
    }

    // TODO
    // Maakt een list aan van parts aan van de twee Strings
    public List<String> getPartsList() {
        List<String> partsList = null;
        String[] partsInArray = partsUsedForRepair.split(";");
        for (String part : partsInArray) {
            partsList.add(part);
        }
        return partsList;
    }

    // TODO
    // Zet de string prijslijst om naar een Arraylist zodat deze uitgelezen kan worden in de getPartsList() methode
    public List<String> getPartPricesList() {
        List<String> partsPricesList = null;
        String[] partsPricesInArray = partsUsedForRepairPrices.split(";");
        for (String partPrice : partsPricesInArray) {
            partsPricesList.add(partPrice);
        }
        return partsPricesList;
    }




    // Getters & Setters

    public long getJobID() {
        return jobID;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public String getStatusToString() {
        switch (status) {
            case 0:
                return "Not active";
            case 1:
                return "Active";
            case 2:
                return "Finished";
            default:
                return "Status not found";
        }
    }

    public int getStatus() {
        return status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public String getPartsUsedForRepair() {
        return partsUsedForRepair;
    }

    public String getPartsUsedForRepairPrices() {
        return partsUsedForRepairPrices;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobID(long ID) {
        this.jobID = ID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String createDateAsString() {
        Date date = new Date();
        return String.valueOf(date.getDate()) + String.valueOf(date.getMonth() + String.valueOf(date.getYear()));
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

