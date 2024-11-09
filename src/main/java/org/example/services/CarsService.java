package org.example.services;

import jakarta.transaction.Transactional;
import org.example.data.BrandsRepository;
import org.example.data.CarsRepository;
import org.example.data.TestDriversRepository;
import org.example.exceptions.ItemDoesNotExistException;
import org.example.models.Car;
import org.example.models.TestDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private BrandsRepository brandsRepository;

    @Autowired
    private TestDriversRepository testDriversRepository;

    public List<Car> getAll(){
        return carsRepository.findAll();
    }

    @Transactional
    public Car addCar(Car car) throws ItemDoesNotExistException {
        //Validation

        //Brand must exist
        if(!brandsRepository.existsById(car.getBrand().getId())){
            throw new ItemDoesNotExistException("CarsService.addCar() [Brand]",
                    car.getLicensePlate());
        }

        //fill the car foreign key
        if(car.getTestDrivers()!=null){
            for (TestDriver testDriver : car.getTestDrivers()) {
                testDriver.setCar(car);
            }
        }

        return carsRepository.save(car);
    }
}
