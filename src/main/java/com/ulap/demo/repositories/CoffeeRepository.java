package com.ulap.demo.repositories;

import com.ulap.demo.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
    public Optional<Coffee> findCoffeeByName(String name);
}
