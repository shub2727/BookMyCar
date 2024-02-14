package com.Car_Rental_CarDetails.Payloads;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApiResponce {


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
