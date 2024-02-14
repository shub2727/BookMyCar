package com.Car_Rental_Booking.Service;

import com.Car_Rental_Booking.Entity.Booking;
import com.Car_Rental_Booking.Entity.Cars;
import com.Car_Rental_Booking.ExternalService.CarService;
import com.Car_Rental_Booking.PayLoads.ApiRequest;
import com.Car_Rental_Booking.PayLoads.ApiResponce;
import com.Car_Rental_Booking.Repository.BookingRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingIservicempl implements BookingService{

    @Autowired
    CarService carService;

    @Autowired
    BookingRepo bookingRepo;

    @Override
    public ApiResponce booking(ApiRequest apiRequest) {

        Cars cars= carService.CarsById(apiRequest.getCarId()).getBody();


        ApiResponce apiResponce= new ApiResponce();



        BeanUtils.copyProperties(apiRequest,apiResponce);
        apiResponce.setCarCompany(cars.getCarCompany());
        apiResponce.setCarColor(cars.getCarColor());
        apiResponce.setCarModel(cars.getCarModel());
        apiResponce.setCarType(cars.getCarType());
        apiResponce.setCarImg(cars.getCarImg());
        apiResponce.setCarOwner(cars.getCarOwner());
        apiResponce.setNumPlate(cars.getNumPlate());
        apiResponce.setInsuranceValidity(cars.getInsuranceValidity());
        apiResponce.setPassangerCapacity(cars.getPassangerCapacity());
        apiResponce.setFuelType(cars.getFuelType());
        apiResponce.setFeature(cars.getFeature());
        apiResponce.setTotalPrice(cars.getCharge()*apiRequest.getDays());

        Booking booking= new Booking();
        BeanUtils.copyProperties(apiRequest,booking);
        booking.setPrice(apiResponce.getTotalPrice());
        bookingRepo.save(booking);
        return apiResponce;
    }

    @Override
    public ApiRequest getBookingById(String id) {
        return null;
    }

    @Override
    public List<ApiRequest> getAllBooking() {
        return null;
    }
}
