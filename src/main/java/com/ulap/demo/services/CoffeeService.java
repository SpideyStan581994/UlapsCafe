package com.ulap.demo.services;

import com.ulap.demo.model.Coffee;
import com.ulap.demo.repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public void addCoffee(Coffee coffee){
        Optional<Coffee> coffeeOptional = coffeeRepository.findCoffeeByName(coffee.getName());
        if(coffeeOptional.isPresent()){
            throw new IllegalStateException("Coffee is already Exists");
        }
        else
            coffeeRepository.save(coffee);

    }

    public List<Coffee> showAllCoffee() {
        return coffeeRepository.findAll();
    }

    public List<String> getAllSugartypes() {
        return List.of("FULL", "MODERATE", "LOW", "NO SUGAR");
    }
}
