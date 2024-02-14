package com.Car_Rental_Driver.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Drivers {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
