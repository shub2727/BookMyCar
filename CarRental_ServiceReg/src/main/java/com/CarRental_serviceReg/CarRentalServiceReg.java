package com.CarRental_serviceReg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CarRentalServiceReg {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalServiceReg.class, args);
	}

}
