package book.my.car.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Cars {

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

    private Cars cars;

}
