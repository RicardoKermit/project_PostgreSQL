package org.example.controllers;

import org.example.data.CarsRepository;
import org.example.exceptions.ItemDoesNotExistException;
import org.example.models.Car;
import org.example.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;

    @GetMapping
    ResponseEntity<List<Car>> getAll(){
        List<Car> cars = carsService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @PostMapping
    ResponseEntity<?> addCar(@RequestBody Car car){
        Car newCar;

        try {
            newCar = carsService.addCar(car);
        } catch (ItemDoesNotExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Brand does not exist...");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return new ResponseEntity<>(newCar, HttpStatus.CREATED);

    }

}
