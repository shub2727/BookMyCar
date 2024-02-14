package com.Car_Rental_Booking.Controller;

import com.Car_Rental_Booking.PayLoads.ApiRequest;
import com.Car_Rental_Booking.PayLoads.ApiResponce;
import com.Car_Rental_Booking.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/")
    public ResponseEntity<ApiResponce> doBooking(@RequestBody ApiRequest apiRequest){

        ApiResponce apiResponce= bookingService.booking(apiRequest);

        return new ResponseEntity<>(apiResponce, HttpStatus.CREATED);
    }


}
