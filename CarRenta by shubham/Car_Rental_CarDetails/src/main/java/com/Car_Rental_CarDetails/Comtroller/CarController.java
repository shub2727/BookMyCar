package com.Car_Rental_CarDetails.Comtroller;

import com.Car_Rental_CarDetails.Payloads.ApiRequest;
import com.Car_Rental_CarDetails.Payloads.ApiResponce;
import com.Car_Rental_CarDetails.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cars")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/")
    public ResponseEntity<ApiResponce> addCar(@RequestBody ApiRequest apiRequest){

        ApiResponce request= carService.createCar(apiRequest);

        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ApiResponce>> getAllCarss(){

        List<ApiResponce> request= carService.getAllCars();

        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponce>CarsById( @PathVariable String id){

        ApiResponce request= carService.getCarById(id);

        return new ResponseEntity<>(request, HttpStatus.OK);
    }

}
