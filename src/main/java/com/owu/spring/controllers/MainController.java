package com.owu.spring.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.owu.spring.dao.CarDAO;
import com.owu.spring.models.Car;
import com.owu.spring.services.CarService;
import com.owu.spring.views.Views;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/cars")
public class MainController {
    private CarDAO carDAO;
    private CarService carService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody @Valid Car car) {
        carService.save(car);
    }

    @GetMapping("")
    @JsonView(value = Views.Level3.class)
    public ResponseEntity <List<Car>> getCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(value = Views.Level1.class)
    public ResponseEntity<Car> getCar(@PathVariable int id) {
        return carService.getCar(id);
    }

    @GetMapping("/power/{powerValue}")
    @JsonView(value = Views.Level2.class)
    public ResponseEntity<List<Car>> getCarsByPowerValue(@PathVariable int powerValue) {
        return carService.getCarsByPowerValue(powerValue);
    }
    @GetMapping("/producer/{producerValue}")
    @JsonView(value = Views.Level2.class)
    public ResponseEntity<List<Car>> getCarsByProducerValue(@PathVariable String producerValue){
        return carService.getCarsByProducerValue(producerValue);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        carService.deleteById(id);
    }
}

