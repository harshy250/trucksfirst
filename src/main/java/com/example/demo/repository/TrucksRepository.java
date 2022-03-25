package com.example.demo.repository;

import com.example.demo.model.Trucks;
import org.springframework.data.jpa.repository.JpaRepository;

// No need to add @Repository because spring data JPA internally takes care of adding
// @Repository annotation
public interface TrucksRepository extends JpaRepository<Trucks, Long> {
    // Get all the crud database methods

}
