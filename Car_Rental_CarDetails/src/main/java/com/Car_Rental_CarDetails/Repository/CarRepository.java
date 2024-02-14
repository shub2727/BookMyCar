package com.Car_Rental_CarDetails.Repository;

import com.Car_Rental_CarDetails.Entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Cars,String> {

   Cars findByCarModel(String nubplate);
}
