package com.Car_Rental_Driver.Controller;

import com.Car_Rental_Driver.PayLoads.ApiRequest;
import com.Car_Rental_Driver.PayLoads.ApiResponce;
import com.Car_Rental_Driver.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/")
    public ResponseEntity<ApiResponce> addDriver(@RequestBody ApiRequest apiRequest){

        ApiResponce request= driverService.createDriver(apiRequest);

        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ApiResponce>> AllDrivers(){

        List<ApiResponce> request= driverService.getAllDrivers();

        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponce> driverById( @PathVariable String id){

        ApiResponce request= driverService.getDriverById(id);

        return new ResponseEntity<>(request, HttpStatus.OK);
    }

}
