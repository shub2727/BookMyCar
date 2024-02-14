package com.Car_Rental_Booking.Repository;

import com.Car_Rental_Booking.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,String> {
}
