package com.Car_Rental_Booking.ExternalService;

import com.Car_Rental_Booking.Entity.Cars;
import com.Car_Rental_Booking.PayLoads.ApiResponce;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (name = "CAR-SERVICE")
public interface CarService {

    @GetMapping("/api/v1/cars/{id}")
    public ResponseEntity<Cars> CarsById(@PathVariable String id);
}
