package com.example.garageeindopdracht.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    private String licensePlate;
//    @JoinColumn
//    @ManyToOne
//    // als er met de list iets fout gaat komt het waarschijnlijk hierdoor
//    private List<Long> previousJobsIDs;
    @Column
    private int modelYear;
    @Column
    private String manufacturer;
    @Column
    private String model;

    // TODO check of de auto al in het systeem staat

    public Car(String licensePlate, int modelYear, String manufacturer, String model) {

    }

    public Car() {

    }

    public String getLicensePlate() {
        return licensePlate;
    }
}