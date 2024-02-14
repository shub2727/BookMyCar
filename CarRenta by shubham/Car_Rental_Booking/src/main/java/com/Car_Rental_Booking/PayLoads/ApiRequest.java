package com.Car_Rental_Booking.PayLoads;

import lombok.Data;

@Data
public class ApiRequest {

    private String id;
    private String carId;
    private String pickUpLocation;
    private String dropLocation;
    private String pickUpTime;
    private String pickUpDate;
    private String dropDate;
    private Integer passangerCapacity;
    private Integer members;
    private Integer days;
    private Integer numBags;
}
