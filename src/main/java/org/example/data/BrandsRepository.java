package org.example.data;

import org.example.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsRepository extends JpaRepository<Brand, Integer> {
}
