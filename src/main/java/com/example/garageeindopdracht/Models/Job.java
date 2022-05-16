package com.example.garageeindopdracht.Models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "jobsTable")
public class Job {
    @Id
    @SequenceGenerator(name = "job_sequence", sequenceName = "job_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_sequence")
    private long ID;
    @Column
    private String carLicensePlate;
    @Column
    private String date;  // TODO Date geeft altijd null ?????
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

    public Job(String carLicensePlate, String customerName, String customerPhoneNumber, String jobDescription) {
        this.carLicensePlate = carLicensePlate;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.jobDescription = jobDescription;
        this.date = createDateAsString();

    }

    public Job() {

    }

    // Voegt een part toe aan de String
    public void addPartToString(Part newPart) {
        partsUsedForRepair = partsUsedForRepair + newPart.getName() + ",";
    }

    // Voegt een prijs toe aan de String
    public void addPartPriceToString(Part newPart) {
        partsUsedForRepairPrices = partsUsedForRepairPrices + newPart.getPrice() + ",";
    }


    // Maakt een list aan van parts aan van de twee Strings
    public List<Part> getPartsList() {
        List<Part> partsList = null;
        if (partsUsedForRepair != null) {
            for (String partName :partsUsedForRepair.split(",")) {
                int counter = 0;    // De counter houdt bij welke integer het programma moet hebben van de Arraylist
                ArrayList<Integer> partPrices = getPartPricesArray();
                Part part = new Part(partName, partPrices.get(counter));
                partsList.add(part);
            }
        } else {
            Part noParts = new Part("No parts were used", 0);
            partsList.add(noParts);
        }
        return partsList;
    }

    // Zet de string prijslijst om naar een Arraylist zodat deze uitgelezen kan worden in de getPartsList() methode
    public ArrayList<Integer> getPartPricesArray() {
        ArrayList<Integer> priceList = null;
        for (String price : partsUsedForRepairPrices.split(",")) {
            priceList.add(Integer.parseInt(price));
        }
        return priceList;
    }



    // Getters & Setters

    public long getID() {
        return ID;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public String getDate() {
        return date;
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

    public void setID(long ID) {
        this.ID = ID;
    }

//    public void setCar(Car car) {
//        this.car = car;
//    }

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
}

