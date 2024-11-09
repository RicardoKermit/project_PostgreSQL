package org.example.services;

import jakarta.transaction.Transactional;
import org.example.data.BrandsRepository;
import org.example.models.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepository brandsRepository;

    public List<Brand> getAll() {
        return brandsRepository.findAll();
    }

    @Transactional
    public Brand add(Brand brand) {
        return brandsRepository.save(brand);
    }

}
