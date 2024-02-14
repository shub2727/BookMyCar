package com.Car_Rental_Booking.Service;

import com.Car_Rental_Booking.PayLoads.ApiRequest;
import com.Car_Rental_Booking.PayLoads.ApiResponce;

import java.util.List;

public interface BookingService {


    public ApiResponce booking(ApiRequest apiRequest);

    public ApiRequest getBookingById(String id);

    public List<ApiRequest> getAllBooking();


}
