package org.example.data;

import org.example.models.TestDriver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDriversRepository extends JpaRepository<TestDriver, Integer> {
}
