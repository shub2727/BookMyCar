package com.Car_Rental_Driver.Service.Impl;

import com.Car_Rental_Driver.Entity.Drivers;
import com.Car_Rental_Driver.Exception.ResourceNotFoundException;
import com.Car_Rental_Driver.PayLoads.ApiRequest;
import com.Car_Rental_Driver.PayLoads.ApiResponce;
import com.Car_Rental_Driver.Repository.DriverRepository;
import com.Car_Rental_Driver.Service.DriverService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;
    @Override
    public ApiResponce createDriver(ApiRequest request) {

        ApiResponce responce= new ApiResponce();

        Drivers drivers= new Drivers();

        BeanUtils.copyProperties(request,drivers);
        driverRepository.save(drivers);
        BeanUtils.copyProperties(request,responce);
        return responce;
    }

    @Override
    public List<ApiResponce> getAllDrivers() {
        List <ApiResponce> apiResponce= new ArrayList<>();

        List<Drivers> driversList = driverRepository.findAll();

        driversList.stream().forEach((drivers)->{
            ApiResponce responce= new ApiResponce();
            BeanUtils.copyProperties(drivers,responce);

            if(!responce.getStatus().equals("booked")){
                apiResponce.add(responce);
            }


        });

        return apiResponce;
    }

    @Override
    public ApiResponce getDriverById(String id) {
        Drivers drivers = driverRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user", "id", id));
        ApiResponce responce= new ApiResponce();

        BeanUtils.copyProperties(drivers,responce);

        return responce;
    }


    @Override
    public void changeStatusOfDriver(String name) {

        Drivers drivers=driverRepository.findByDriverMobNo(name);
        drivers.setStatus("booked");
        driverRepository.save(drivers);


    }
}
