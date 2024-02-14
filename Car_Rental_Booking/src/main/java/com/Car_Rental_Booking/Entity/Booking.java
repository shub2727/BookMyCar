package com.Car_Rental_Booking.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String carId;
    private String pickUpLocation;
    private String dropLocation;
    private String pickUpTime;
    private String pickUpDate;
    private Long price;
    private String dropDate;
    private Integer passangerCapacity;
    private Integer members;
    private Integer days;
    private Integer numBags;

    @Transient
    private Cars cars;
}
