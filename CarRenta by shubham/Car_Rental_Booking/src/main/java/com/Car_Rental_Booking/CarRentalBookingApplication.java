package com.Car_Rental_Booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CarRentalBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalBookingApplication.class, args);
	}

}
