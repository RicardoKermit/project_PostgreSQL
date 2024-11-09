package org.example.controllers;

import jakarta.persistence.GeneratedValue;
import org.example.models.Brand;
import org.example.services.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/controller")
public class BrandsController {

    @Autowired
    private BrandsService brandsService;

    @GetMapping
    ResponseEntity<List<Brand>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(brandsService.getAll());
    }

    @PostMapping
    ResponseEntity<Brand> add(@RequestBody Brand brand){
        return ResponseEntity.status(HttpStatus.CREATED).body(brandsService.add(brand));
    }
}
