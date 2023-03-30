package com.owu.spring.controllers;

import com.owu.spring.dao.CarDAO;
import com.owu.spring.models.Car;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {
    private CarDAO carDAO;

    @PostMapping("/cars")
    public void save(@RequestBody Car car) {
        carDAO.save(car);
    }

    @GetMapping("/cars")
    public List<Car> getCars() {
        return carDAO.findAll();
    }

    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable int id) {
        return carDAO.findById(id).get();
    }

    @GetMapping("/cars/power/{powerValue}")
    public List<Car> carsByPower(@PathVariable int powerValue) {
        return carDAO.findCarByPower(powerValue);
    }
    @GetMapping("/cars/producer/{producerValue}")
    public List<Car> carsByProducer(@PathVariable String producerValue){
        return carDAO.findCarsByProducer(producerValue);
    }

    @DeleteMapping("/cars/{id}")
    public List<Car> deleteCar(@PathVariable int id) {
        carDAO.deleteById(id);
        return carDAO.findAll();
    }
}

