package com.Car_Rental_CarDetails.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String carCompany;
    private String carColor;
    private String carModel;
    private String carType;
    private String status;
    private String carImg;
    private String car360;
    private String carOwner;
    private String numPlate;
    private LocalDate regDate;
    private String insurance;
    private String insuranceValidity;
    private Integer passangerCapacity;
    private String fuelType;
    private String feature;
    private Long totalRunning;
    private Long charge;



}
