package com.Car_Rental_Driver.Repository;

import com.Car_Rental_Driver.Entity.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Drivers,String> {
}
