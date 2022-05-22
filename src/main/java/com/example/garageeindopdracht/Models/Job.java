package com.example.garageeindopdracht.Models;

import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        if (partsUsedForRepair == null) {
            partsUsedForRepair = newPart + ";";
        } else {
            partsUsedForRepair = partsUsedForRepair + newPart + ";";
        }
    }

    public void addPartPriceToString(String newPartPrice) {
        if (partsUsedForRepairPrices == null) {
            partsUsedForRepairPrices = newPartPrice + ";";
        } else {
            partsUsedForRepairPrices = partsUsedForRepairPrices + newPartPrice + ";";
        }
    }


    public Optional<List<String>> getPartsList() {
        List<String> partsList = new ArrayList<>();
        if (partsUsedForRepair != null) {
            String[] partsInArray = partsUsedForRepair.split(";");
            for (String part : partsInArray) {
                partsList.add(part);
            }
        }
        Optional<List<String>> partsListOptional = Optional.ofNullable(partsList);
        return partsListOptional;
    }


    public Optional<List<String>> getPartsPricesList() {
        List<String> partsPricesList = new ArrayList<>();
        if (partsUsedForRepairPrices != null) {
            String[] partsPricesInArray = partsUsedForRepairPrices.split(";");
            for (String partPrice : partsPricesInArray) {
                partsPricesList.add(partPrice);
            }
        }
        Optional<List<String>> partsPricesListOptional = Optional.ofNullable(partsPricesList);
        return partsPricesListOptional;
    }

    public Optional<List<Double>> getPartPricesListDouble() {
        List<Double> partPricesListDouble = new ArrayList<>();
        for (String partPrice : getPartsPricesList().get()) {
            partPrice = partPrice.replaceAll(",",".");
            Double partPriceDouble = Double.parseDouble(partPrice);
            partPricesListDouble.add(partPriceDouble);
        }
        Optional<List<Double>> partPricesListOptional = Optional.of(partPricesListDouble);
        return partPricesListOptional;
    }

    public double getTotalRepairCost() {
        double totalRepairCost = 0.00;
        int counter = 0;
        if (getPartPricesListDouble().isPresent()) {
            List<Double> partPricesList = getPartPricesListDouble().get();
            for (double partPrice : getPartPricesListDouble().get()) {

                totalRepairCost = totalRepairCost + partPricesList.get(counter);
                counter++;
            }
        }
        return totalRepairCost;
    }

    public List<Part> getAllParts() {
        List<Part> listOfParts = new ArrayList<>();
        if (getPartsList().isPresent() && getPartsPricesList().isPresent()) {
            List<String> partList = getPartsList().get();
            List<String> partPricesList = getPartsPricesList().get();
            int index = 0;
            for (String part : partList) {
                Part newPart = new Part(partList.get(index), partPricesList.get(index));
                index++;
                listOfParts.add(newPart);
            }
        }

        return listOfParts;
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
            case 3:
                return "Concluded";
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


    public void setStatus(int status) {
        this.status = status;
    }

    public void setPartsUsedForRepair(String partsUsedForRepair) {
        this.partsUsedForRepair = partsUsedForRepair;
    }

    public void setPartsUsedForRepairPrices(String partsUsedForRepairPrices) {
        this.partsUsedForRepairPrices = partsUsedForRepairPrices;
    }
}

