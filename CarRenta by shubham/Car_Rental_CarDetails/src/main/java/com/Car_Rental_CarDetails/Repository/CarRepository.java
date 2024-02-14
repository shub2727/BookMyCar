package com.Car_Rental_CarDetails.Repository;

import com.Car_Rental_CarDetails.Entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Cars,String> {
}
