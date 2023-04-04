package com.owu.spring.services;

import com.owu.spring.dao.CarDAO;
import com.owu.spring.models.Car;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private CarDAO carDAO;
    private MailService mailService;
    public void save(Car car){
        if(car == null){
            throw new RuntimeException();
        }
        carDAO.save(car);
        mailService.sendEmail(car);
    }

    public ResponseEntity<List<Car>> findAll(){
        return new ResponseEntity<>(carDAO.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Car> getCar(int id){
        System.out.println(carDAO.findById(id));
        return new ResponseEntity<Car>(carDAO.findById(id).get(),HttpStatus.OK);
    }

    public ResponseEntity<List<Car>> getCarsByPowerValue(int powerValue){
        return new ResponseEntity<>(carDAO.findCarByPower(powerValue),HttpStatus.OK);
    }

    public ResponseEntity<List<Car>> getCarsByProducerValue(String producerValue){
        return new ResponseEntity<>(carDAO.findCarsByProducer(producerValue), HttpStatus.OK);
    }

    public void deleteById(int id){
        carDAO.deleteById(id);
    }
}
