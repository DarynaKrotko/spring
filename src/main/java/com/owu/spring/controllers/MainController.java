package com.owu.spring.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.owu.spring.dao.CarDAO;
import com.owu.spring.models.Car;
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

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody @Valid Car car) {
        carDAO.save(car);
    }

    @GetMapping("")
    @JsonView(value = Views.Level3.class)
    public ResponseEntity <List<Car>> getCars() {
        return new ResponseEntity<>(carDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @JsonView(value = Views.Level1.class)
    public ResponseEntity<Car> getCar(@PathVariable int id) {
        return new ResponseEntity<>(carDAO.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/power/{powerValue}")
    @JsonView(value = Views.Level2.class)
    public ResponseEntity<List<Car>> carsByPower(@PathVariable int powerValue) {
        return new ResponseEntity<>(carDAO.findCarByPower(powerValue),HttpStatus.OK);
    }
    @GetMapping("/producer/{producerValue}")
    @JsonView(value = Views.Level2.class)
    public ResponseEntity<List<Car>> carsByProducer(@PathVariable String producerValue){
        return new ResponseEntity<>(carDAO.findCarsByProducer(producerValue), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Car>> deleteCar(@PathVariable int id) {
        carDAO.deleteById(id);
        return new ResponseEntity<>(carDAO.findAll(), HttpStatus.OK);
    }
}

