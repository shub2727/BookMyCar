package com.Car_Rental_Driver.PayLoads;

import lombok.Data;

@Data
public class ApiRequest {

    private String id;
    private String driverImg;
    private String driverName;
    private String drivingExperiance;
    private String driverMobNo;
    private String availability;
    private String food;
    private String smoke;
    private String drink;
    private Integer charges;
}
