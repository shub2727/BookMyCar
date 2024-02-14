package com.Car_Rental_Driver.Service;

import com.Car_Rental_Driver.PayLoads.ApiRequest;
import com.Car_Rental_Driver.PayLoads.ApiResponce;

import java.util.List;

public interface DriverService {

    public ApiResponce createDriver(ApiRequest request);

    public List<ApiResponce> getAllDrivers();

    public ApiResponce getDriverById(String id);

}
