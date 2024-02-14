package com.Car_Rental_CarDetails.Service;

import com.Car_Rental_CarDetails.Entity.Cars;
import com.Car_Rental_CarDetails.Payloads.ApiRequest;
import com.Car_Rental_CarDetails.Payloads.ApiResponce;

import java.util.List;
import java.util.Map;

public interface CarService {

    public ApiResponce createCar(ApiRequest apiRequest);

    public ApiResponce getCarById(String id);

    public List<ApiResponce>getAllCars();

    public void changeStatusOfcar(String id);
}
