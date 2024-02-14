package com.Car_Rental_Booking.PayLoads;

import lombok.Data;

@Data
public class ApiResponce {

    private String id;
    private String carCompany;
    private String carColor;
    private String carModel;
    private String carType;
    private String carOwner;
    private String carImg;
    private String numPlate;
    private String insuranceValidity;
    private String fuelType;
    private String feature;
    private String pickUpLocation;
    private String dropLocation;
    private String pickUpTime;
    private String pickUpDate;
    private String dropDate;
    private Integer passangerCapacity;
    private Integer members;
    private Integer days;
    private Integer numBags;
    private Long totalPrice;
}
