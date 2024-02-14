package com.Car_Rental_CarDetails.Service.Impl;

import com.Car_Rental_CarDetails.Entity.Cars;
import com.Car_Rental_CarDetails.Exception.ResourceNotFoundException;
import com.Car_Rental_CarDetails.Payloads.ApiRequest;
import com.Car_Rental_CarDetails.Payloads.ApiResponce;
import com.Car_Rental_CarDetails.Repository.CarRepository;
import com.Car_Rental_CarDetails.Service.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public ApiResponce createCar(ApiRequest apiRequest) {

        ApiResponce responce= new ApiResponce();
        Cars cars=new Cars();
        BeanUtils.copyProperties(apiRequest,cars);
        carRepository.save(cars);
        BeanUtils.copyProperties(apiRequest,responce);

        return responce;
    }

    @Override
    public ApiResponce getCarById(String id) {
        Cars car = carRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user", "id", id));
        ApiResponce responce= new ApiResponce();

        BeanUtils.copyProperties(car,responce);

        return responce;
    }

    @Override
    public List<ApiResponce> getAllCars() {
      List <ApiResponce> apiResponce= new ArrayList<>();

         List<Cars> carslist = carRepository.findAll();

         carslist.stream().forEach((car)->{
             ApiResponce responce= new ApiResponce();
             BeanUtils.copyProperties(car,responce);

             apiResponce.add(responce);
         });

         return apiResponce;


    }
}
